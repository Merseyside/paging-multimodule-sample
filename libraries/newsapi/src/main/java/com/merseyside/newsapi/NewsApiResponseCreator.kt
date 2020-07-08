package com.merseyside.newsapi

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.merseyside.newsapi.response.NewsPageResponse
import com.merseyside.newsapi.service.NewsService
import com.merseyside.utils.serialization.deserialize
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.HttpUrl
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiResponseCreator(client: OkHttpClient.Builder) {

    private lateinit var newsService: NewsService

    init {
        initService(client)
    }

    private fun initService(builder: OkHttpClient.Builder) {
        builder.addInterceptor { chain ->
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url()

            val url: HttpUrl = originalHttpUrl.newBuilder()
                .addQueryParameter("q", BuildConfig.PLATFORM)
                .addQueryParameter("from", BuildConfig.FROM)
                .addQueryParameter("sortBy", BuildConfig.SORT_BY)
                .addQueryParameter("apiKey", BuildConfig.API_KEY)
                .build()

            val requestBuilder = original.newBuilder().url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val contentType = MediaType.get("application/json")
        newsService = Retrofit.Builder()
            .client(builder.build())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(Json(JsonConfiguration(
                ignoreUnknownKeys = true,
                isLenient = true
            )).asConverterFactory(contentType))
            .build()
            .create(NewsService::class.java)
    }

    suspend fun getNews(page: Int): NewsPageResponse {
        return newsService.getNews(page)
    }
}