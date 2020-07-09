package com.merseyside.newsList.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.merseyside.adapters.base.BasePagedAdapter
import com.merseyside.archy.ext.getString
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.news.application
import com.merseyside.newsList.R
import com.merseyside.newsList.BR
import com.merseyside.newsList.ui.model.ConnectionViewModel
import com.merseyside.newsList.ui.model.NewsItemViewModel
import com.merseyside.utils.exception.NoInternetConnection
import com.merseyside.utils.ext.log

class NewsPagingAdapter(private val onRetry: () -> Unit)
    : BasePagedAdapter<NewsEntity, NewsItemViewModel>(COMPARATOR) {

    override fun createItemViewModel(obj: NewsEntity): NewsItemViewModel {
        return NewsItemViewModel(obj)
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.view_news
    }

    override fun getBindingVariable(): Int {
        return BR.obj
    }

    override fun getNetworkConnectionLayout(): Int {
        return R.layout.view_network_connection
    }

    override fun getNetworkConnectionModel(): ConnectionViewModel {
        return ConnectionViewModel().apply {
            setOnRetryListener(object: INetworkState.OnRetryListener {
                override fun onRetry() {
                    setNetworkState(NetworkState.LOADING, "Loading...")

                    onRetry.invoke()
                }
            })
        }
    }

    fun setNetworkState(state: com.merseyside.core.network.NetworkState) {
        when(state) {
            is com.merseyside.core.network.NetworkState.Error -> {
                when (state.throwable) {
                    is NoInternetConnection -> {
                        val msg = getString(application, R.string.no_internet_connection)
                        setNetworkState(NetworkState.NO_CONNECTION, msg)
                    }
                    else -> {
                        val msg = state.throwable.message
                        setNetworkState(NetworkState.ERROR, msg)
                    }
                }
            }

            is com.merseyside.core.network.NetworkState.Success -> {
                setNetworkState(NetworkState.CONNECTED)
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<NewsEntity>() {

            override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}