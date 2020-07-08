package com.merseyside.newsList.ui.model

import androidx.databinding.Bindable
import com.merseyside.adapters.model.BaseAdapterViewModel
import com.merseyside.core.db.news.NewsEntity

class NewsItemViewModel(override var obj: NewsEntity) : BaseAdapterViewModel<NewsEntity>(obj) {

    override fun areItemsTheSame(obj: NewsEntity): Boolean {
        return obj.id == obj.id
    }

    override fun notifyUpdate() {}

    @Bindable
    fun getTitle(): String {
        return obj.title
    }

    @Bindable
    fun getAuthor(): String {
        return obj.author ?: "No author"
    }

    @Bindable
    fun getDescription(): String {
        return obj.description
    }
}