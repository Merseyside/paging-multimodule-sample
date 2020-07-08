package com.merseyside.newsList.ui.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import com.merseyside.commons.ui.base.BaseAppViewModel
import com.merseyside.core.NewsRepository
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.news.application

class NewsViewModel(
    private val repository: NewsRepository
) : BaseAppViewModel() {

    private val repoResult = repository.getNews(1)

    val news = repoResult.pagedList
    //val networkState = repoResult.networkState
    //val refreshState = repoResult.refreshState

    override fun getLocaleContext(): Context {
        return application
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

    fun getNewsPagedList(): LiveData<PagedList<NewsEntity>> {
        return repoResult.pagedList
    }
}
