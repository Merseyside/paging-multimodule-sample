package com.merseyside.core.db.news

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert
    fun insert(entities: List<NewsEntity>)

    @Query("SELECT * FROM news")
    fun getSourceFactory() : DataSource.Factory<Int, NewsEntity>

    @Query("SELECT page FROM news WHERE ID = (SELECT MAX(ID) FROM news)")
    fun getLastLoadedPage(): Int

    @Query("DELETE FROM news")
    suspend fun nukeTable()
}