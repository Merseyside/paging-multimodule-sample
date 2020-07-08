package com.merseyside.core.di.modules

import android.content.Context
import com.merseyside.core.BuildConfig
import com.merseyside.core.NewsRepository
import com.merseyside.core.db.news.NewsDao
import com.merseyside.core.network.repository.NewsRepositoryImpl
import com.merseyside.core.network.repository.mapper.NewsMapper
import com.merseyside.core.utils.ConnectivityInterceptor
import com.merseyside.newsapi.NewsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideConnectionInterceptor(context: Context): ConnectivityInterceptor {
        return ConnectivityInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        connectivityInterceptor: ConnectivityInterceptor
    ): OkHttpClient.Builder {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.apply {
                addInterceptor(loggingInterceptor)
                addInterceptor(connectivityInterceptor)
            }
        }
        return clientBuilder
    }

    @Singleton
    @Provides
    fun provideNewsApi(okHttpClient: OkHttpClient.Builder): NewsApi {
        return NewsApi(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideRepository(
        newsApi: NewsApi,
        newsDao: NewsDao,
        newsMapper: NewsMapper
    ): NewsRepository = NewsRepositoryImpl(
        newsApi, newsDao, newsMapper
    )
}
