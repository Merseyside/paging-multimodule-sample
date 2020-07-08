package com.merseyside.core.db.news

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert
    fun insert(entities: List<NewsEntity>)

    @Query("SELECT * FROM news WHERE page = :page")
    fun getPage(page: Int) : DataSource.Factory<Int, NewsEntity>

    @Query("DELETE FROM news")
    suspend fun nukeTable()
}