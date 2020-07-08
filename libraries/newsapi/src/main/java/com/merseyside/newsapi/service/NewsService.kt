package com.merseyside.newsapi.service

import com.merseyside.newsapi.response.NewsPageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything/")
    suspend fun getNews(@Query("page") page: Int): NewsPageResponse
}