package com.merseyside.news.di

import com.merseyside.core.di.CoreComponent
import com.merseyside.news.NewsApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class])
interface AppComponent {

    fun inject(): NewsApp
}