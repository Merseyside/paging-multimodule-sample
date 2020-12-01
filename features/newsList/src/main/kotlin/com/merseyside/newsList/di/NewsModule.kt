package com.merseyside.newsList.di

import android.app.Application
import android.os.Bundle
import com.merseyside.archy.presentation.ext.viewModel
import com.merseyside.core.NewsRepository
import com.merseyside.core.di.scopes.FeatureScope
import com.merseyside.newsList.ui.model.NewsViewModel
import com.merseyside.newsList.ui.view.NewsFragment
import dagger.Module
import dagger.Provides

@Module
class NewsModule(
    private val fragment: NewsFragment,
    private val bundle: Bundle?
) {

    @Provides
    @FeatureScope
    fun provideNewsViewModel(
        application: Application,
        repository: NewsRepository
    ) = fragment.viewModel(
        bundle = bundle
    ) { NewsViewModel(application, repository) }
}
