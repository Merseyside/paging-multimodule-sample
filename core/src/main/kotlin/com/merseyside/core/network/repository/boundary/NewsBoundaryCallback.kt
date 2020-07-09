package com.merseyside.core.network.repository.boundary

import androidx.annotation.MainThread
import androidx.paging.PagedList
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.core.utils.PagingRequestHelper
import com.merseyside.core.utils.createStatusLiveData
import com.merseyside.newsapi.NewsApi
import com.merseyside.newsapi.response.NewsPageResponse
import com.merseyside.utils.ext.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import kotlin.coroutines.CoroutineContext

class NewsBoundaryCallback(
    private var page: Int = 1,
    private val newsApi: NewsApi,
    private val handleResponse: (Int, NewsPageResponse) -> Unit,
    private val ioExecutor: Executor
) : PagedList.BoundaryCallback<NewsEntity>(), CoroutineScope {

    val helper = PagingRequestHelper(ioExecutor)
    val networkState = helper.createStatusLiveData()

    /**
     * Database returned 0 items. We should query the backend for more items.
     */
    @MainThread
    override fun onZeroItemsLoaded() {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.INITIAL) { callback ->
            obtainNews(callback)
        }
    }

    /**
     * User reached to the end of the list.
     */
    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: NewsEntity) {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.AFTER) { callback ->
            obtainNews(callback)
        }
    }

    /**
     * every time it gets new items, boundary callback simply inserts them into the database and
     * paging library takes care of refreshing the list if necessary.
     */
    private fun insertItemsIntoDb(
        response: NewsPageResponse,
        callback: PagingRequestHelper.Request.Callback) {
        ioExecutor.execute {
            callback.recordSuccess()
            handleResponse(page, response)
        }
    }

    override fun onItemAtFrontLoaded(itemAtFront: NewsEntity) {}

    private fun obtainNews(
        callback: PagingRequestHelper.Request.Callback) {
        launch {

            try {
                val response = newsApi.getNews(page + 1)
                insertItemsIntoDb(response, callback)

                page++
            } catch (e: Throwable) {
                delay(1000)
                callback.recordFailure(e)
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}