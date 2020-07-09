package com.merseyside.newsList.ui.model

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.paging.PagedList
import com.merseyside.commons.ui.base.BaseAppViewModel
import com.merseyside.core.NewsRepository
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.core.network.repository.listing.Listing
import com.merseyside.news.application
import com.merseyside.utils.ext.log
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsRepository
) : BaseAppViewModel() {

    private val repoResult = liveData {
        emit(repository.getNews())
    }

    val newsLiveData = Transformations.switchMap(repoResult) { it.pagedList }
    val networkState = Transformations.switchMap(repoResult) { it.networkState }

//    val newsLiveData = liveData {
//        emitSource(repository.getNews().pagedList)
//    }



    val listObservableField = ObservableField<PagedList<NewsEntity>>()

    //val networkState = repoResult.networkState
    //val refreshState = repoResult.refreshState

    override fun getLocaleContext(): Context {
        return application
    }

    override fun dispose() {}
}
