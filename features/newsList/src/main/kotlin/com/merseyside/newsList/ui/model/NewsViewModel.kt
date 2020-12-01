package com.merseyside.newsList.ui.model

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import androidx.paging.PagedList
import com.merseyside.commons.ui.base.BaseAppViewModel
import com.merseyside.core.NewsRepository
import com.merseyside.core.db.news.NewsEntity

class NewsViewModel(
    application: Application,
    private val repository: NewsRepository
) : BaseAppViewModel(application) {

    private val repoResult = liveData {
        emit(repository.getNews())
    }

    val newsLiveData = Transformations.switchMap(repoResult) { it.pagedList }
    val networkState = Transformations.switchMap(repoResult) { it.networkState }

    fun retry() {
        val listing = repoResult.value
        listing?.retry?.invoke()
    }

    val listObservableField = ObservableField<PagedList<NewsEntity>>()

    override fun dispose() {}
}
