package com.merseyside.newsList.di

import com.merseyside.core.di.CoreComponent
import com.merseyside.core.di.scopes.FeatureScope
import com.merseyside.newsList.ui.NewsFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [NewsModule::class],
    dependencies = [CoreComponent::class])
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)
}
