package com.merseyside.newsList.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.merseyside.adapters.base.BasePagedAdapter
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.newsList.R
import com.merseyside.newsList.BR
import com.merseyside.newsList.ui.model.ConnectionViewModel
import com.merseyside.newsList.ui.model.NewsItemViewModel

class NewsPagingAdapter : BasePagedAdapter<NewsEntity, NewsItemViewModel>(COMPARATOR) {

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
        return ConnectionViewModel()
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