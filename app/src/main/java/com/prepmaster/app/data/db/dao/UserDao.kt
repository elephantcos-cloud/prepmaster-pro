package com.prepmaster.app.data.db.dao

import androidx.room.*
import com.prepmaster.app.data.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id=1 LIMIT 1")
    fun get(): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(u: UserEntity)

    @Update
    suspend fun update(u: UserEntity)

    @Query("UPDATE users SET xp=xp+:gain, level=:lv WHERE id=1")
    suspend fun addXp(gain: Int, lv: Int)

    @Query("UPDATE users SET totalStudied=totalStudied+1 WHERE id=1")
    suspend fun incStudied()

    @Query("UPDATE users SET quizCorrect=quizCorrect+:c, quizTotal=quizTotal+:t WHERE id=1")
    suspend fun addQuiz(c: Int, t: Int)

    @Query("UPDATE users SET practiceCorrect=practiceCorrect+:c, practiceTotal=practiceTotal+:t WHERE id=1")
    suspend fun addPractice(c: Int, t: Int)

    @Query("UPDATE users SET flashcardsViewed=flashcardsViewed+1 WHERE id=1")
    suspend fun incFlashcard()

    @Query("UPDATE users SET streak=:s, lastStudyDate=:d WHERE id=1")
    suspend fun updateStreak(s: Int, d: String)

    @Query("UPDATE users SET builderCorrect=builderCorrect+:c, builderTotal=builderTotal+:t WHERE id=1")
    suspend fun addBuilder(c: Int, t: Int)
}
