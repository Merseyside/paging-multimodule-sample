package com.merseyside.core.network.repository

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.merseyside.core.NewsRepository
import com.merseyside.core.db.news.NewsDao
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.core.network.NetworkState
import com.merseyside.core.network.repository.boundary.NewsBoundaryCallback
import com.merseyside.core.network.repository.listing.Listing
import com.merseyside.core.network.repository.mapper.NewsMapper
import com.merseyside.newsapi.NewsApi
import com.merseyside.newsapi.response.NewsPageResponse
import java.util.concurrent.Executors

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao,
    private val newsMapper: NewsMapper,
    private val pageSize: Int
): NewsRepository {

    val ioExecutor = Executors.newSingleThreadExecutor()

    override suspend fun getNews(page: Int): Listing<NewsEntity> {
        val boundaryCallback = NewsBoundaryCallback(
            newsApi = newsApi,
            page = page,
            handleResponse = this::insertResultIntoDb,
            ioExecutor = ioExecutor
        )

        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger) {
            refresh(page)
        }

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .

        val livePagedList = LivePagedListBuilder(newsDao.getPage(page), pageSize)
            .setBoundaryCallback(boundaryCallback)
            .build()

        return Listing(
            pagedList = livePagedList,
            networkState = boundaryCallback.networkState,
            retry = {
                boundaryCallback.helper.retryAllFailed()
            },
            refresh = {
                refreshTrigger.value = null
            },
            refreshState = refreshState
        )
    }

    @MainThread
    private fun refresh(page: Int): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.Loading

        try {
            val response = newsApi.getNews(page)

            newsDao.nukeTable()
            insertResultIntoDb(page, response)

            networkState.postValue(NetworkState.Success)
        } catch (t: Throwable) {
            networkState.value = NetworkState.Error(t, t.message)
        }

        return networkState
    }

    private fun insertResultIntoDb(page: Int, response: NewsPageResponse) {
        val entities = newsMapper.map(response to page)

        newsDao.insert(entities)
    }
}