package com.merseyside.news.di

import android.content.Context
import com.merseyside.news.NewsApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: NewsApp): Context = application.applicationContext
}