package com.prepmaster.app.data.repository

import android.content.Context
import com.prepmaster.app.data.content.*
import com.prepmaster.app.data.db.AppDatabase
import com.prepmaster.app.data.db.entity.*
import com.prepmaster.app.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AppRepository(ctx: Context) {
    private val db          = AppDatabase.get(ctx)
    private val userDao     = db.userDao()
    private val progDao     = db.progressDao()
    private val badgeDao    = db.badgeDao()
    private val bookmarkDao = db.bookmarkDao()

    companion object {
        @Volatile private var INSTANCE: AppRepository? = null
        fun get(ctx: Context) = INSTANCE ?: synchronized(this) {
            AppRepository(ctx.applicationContext).also { INSTANCE = it }
        }
    }

    // ── Content ────────────────────────────────────────────────────────
    fun getCategories()        = allCategories
    fun getQuizQuestions()     = allQuizQuestions
    fun getPracticeItems()     = allPracticeItems
    fun getStories()           = allStories
    fun getCategory(id: String)= allCategories.find { it.id == id }
    fun getComparisons()       = allComparisonGroups
    fun getSentenceBuilder()   = allSentenceBuilderItems
    fun getGrammarRules()      = allGrammarRules

    fun getAllFlashCards(): List<FlashCard> = allCategories.flatMap { cat ->
        cat.prepositions.map { prep ->
            FlashCard(prep.id, prep.word, prep.meaning,
                prep.examples.firstOrNull()?.sentence ?: "",
                prep.imageType, cat.id, cat.color)
        }
    }.shuffled()

    // ── User ───────────────────────────────────────────────────────────
    fun userFlow(): Flow<UserEntity?> = userDao.get()
    suspend fun ensureUser() {
        if (userDao.get().first() == null)
            userDao.insert(UserEntity(joinDate = today()))
    }
    suspend fun updateUser(u: UserEntity) = userDao.update(u)

    fun statsFlow(): Flow<UserStats> = userDao.get().map { u ->
        if (u == null) UserStats(0,1,0,0,0,0,0,0,0,"শিক্ষার্থী",20,0)
        else UserStats(u.xp,u.level,u.streak,u.totalStudied,
            u.quizCorrect,u.quizTotal,u.practiceCorrect,u.practiceTotal,
            u.flashcardsViewed,u.name,u.studyGoalMins,u.todayMins,
            u.builderCorrect,u.builderTotal)
    }

    // ── Progress ───────────────────────────────────────────────────────
    fun progressFlow(): Flow<List<ProgressEntity>> = progDao.getAll()

    suspend fun markLearned(prep: PrepItem) {
        if (progDao.get(prep.id)?.learned == true) return
        progDao.insert(ProgressEntity(prep.id, prep.categoryId, true, today(), 15))
        userDao.incStudied()
        val u = userDao.get().first() ?: return
        val newXp = u.xp + 15
        userDao.addXp(15, xpToLevel(newXp))
        updateStreak()
        checkBadges(newXp, u.totalStudied + 1)
    }

    suspend fun recordQuiz(correct: Int, total: Int) {
        userDao.addQuiz(correct, total)
        val u = userDao.get().first() ?: return
        val gain = correct * 10
        userDao.addXp(gain, xpToLevel(u.xp + gain))
        checkBadges(u.xp + gain, u.totalStudied)
    }

    suspend fun recordPractice(correct: Int, total: Int) {
        userDao.addPractice(correct, total)
        val u = userDao.get().first() ?: return
        val gain = correct * 5
        userDao.addXp(gain, xpToLevel(u.xp + gain))
    }

    suspend fun recordFlashcard() {
        userDao.incFlashcard()
        val u = userDao.get().first() ?: return
        userDao.addXp(2, xpToLevel(u.xp + 2))
    }

    suspend fun recordBuilder(correct: Int, total: Int) {
        userDao.addBuilder(correct, total)
        val u = userDao.get().first() ?: return
        val gain = correct * 8
        userDao.addXp(gain, xpToLevel(u.xp + gain))
    }

    // ── Bookmarks ──────────────────────────────────────────────────────
    fun bookmarkIdsFlow(): Flow<List<String>> = bookmarkDao.getIds()
    fun bookmarksFlow(): Flow<List<BookmarkEntity>> = bookmarkDao.getAll()

    suspend fun toggleBookmark(prep: PrepItem) {
        if (bookmarkDao.exists(prep.id) > 0) {
            bookmarkDao.delete(prep.id)
        } else {
            bookmarkDao.insert(BookmarkEntity(prep.id, prep.categoryId, today()))
        }
    }

    suspend fun isBookmarked(prepId: String): Boolean = bookmarkDao.exists(prepId) > 0

    fun getBookmarkedPreps(bookmarkIds: List<String>): List<PrepItem> {
        val idSet = bookmarkIds.toSet()
        return allCategories.flatMap { it.prepositions }.filter { it.id in idSet }
    }

    // ── Badges ─────────────────────────────────────────────────────────
    fun badgesFlow(): Flow<List<BadgeEntity>> = badgeDao.getAll()

    private suspend fun checkBadges(xp: Int, studied: Int) {
        val list = mutableListOf<String>()
        if (studied >= 1)   list += "first_prep"
        if (studied >= 10)  list += "explorer"
        if (studied >= 25)  list += "learner"
        if (studied >= 50)  list += "scholar"
        if (studied >= 100) list += "master"
        if (xp >= 100)      list += "xp_100"
        if (xp >= 500)      list += "xp_500"
        if (xp >= 1000)     list += "xp_1000"
        if (xp >= 5000)     list += "xp_5000"
        val u = userDao.get().first() ?: return
        if (u.streak >= 3)  list += "streak_3"
        if (u.streak >= 7)  list += "streak_7"
        if (u.streak >= 30) list += "streak_30"
        list.forEach { badgeDao.insert(BadgeEntity(it, today())) }
    }

    private suspend fun updateStreak() {
        val u = userDao.get().first() ?: return
        val tod  = today()
        val yest = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE)
        val ns   = when(u.lastStudyDate) { tod -> u.streak; yest -> u.streak+1; else -> 1 }
        userDao.updateStreak(ns, tod)
    }

    // ── XP helpers ─────────────────────────────────────────────────────
    fun xpProgress(xp: Int): Pair<Int,Int> {
        val lvls = listOf(0,100,250,500,900,1500,2500,4000,6000,9000,15000)
        val lv   = xpToLevel(xp)
        return Pair(xp - lvls.getOrElse(lv-1){0}, lvls.getOrElse(lv){15000} - lvls.getOrElse(lv-1){0})
    }

    fun xpToLevel(xp: Int) = when {
        xp<100->1; xp<250->2; xp<500->3; xp<900->4; xp<1500->5
        xp<2500->6; xp<4000->7; xp<6000->8; xp<9000->9; else->10
    }

    private fun today() = LocalDate.now().format(DateTimeFormatter.ISO_DATE)
}
