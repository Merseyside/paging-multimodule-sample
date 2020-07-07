package com.merseyside.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.merseyside.core.db.news.NewsDao
import com.merseyside.core.db.news.NewsEntity

@Database(
    entities = [NewsEntity::class],
    exportSchema = false,
    version = 1)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}