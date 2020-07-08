package com.merseyside.core

import com.merseyside.core.db.news.NewsEntity
import com.merseyside.core.network.repository.listing.Listing

interface NewsRepository {

    suspend fun getNews(): Listing<NewsEntity>
}