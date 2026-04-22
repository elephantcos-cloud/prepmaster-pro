package com.prepmaster.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val prepId    : String,
    val categoryId : String = "",
    val addedDate  : String = ""
)
