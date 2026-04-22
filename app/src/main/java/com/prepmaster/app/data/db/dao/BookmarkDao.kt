package com.prepmaster.app.data.db.dao

import androidx.room.*
import com.prepmaster.app.data.db.entity.BookmarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks ORDER BY addedDate DESC")
    fun getAll(): Flow<List<BookmarkEntity>>

    @Query("SELECT prepId FROM bookmarks")
    fun getIds(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(b: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE prepId = :id")
    suspend fun delete(id: String)

    @Query("SELECT COUNT(*) FROM bookmarks WHERE prepId = :id")
    suspend fun exists(id: String): Int
}
