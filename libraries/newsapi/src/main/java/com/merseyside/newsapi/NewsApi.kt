package com.merseyside.newsapi

import com.merseyside.newsapi.response.NewsPageResponse
import com.merseyside.utils.exception.NoInternetConnection
import okhttp3.OkHttpClient

class NewsApi(private val httpClient: OkHttpClient.Builder) {

    private val creator = NewsApiResponseCreator(httpClient)

    suspend fun getNews(page: Int): NewsPageResponse {
        return creator.getNews(page)
    }
}