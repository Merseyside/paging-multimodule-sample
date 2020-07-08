package com.merseyside.newsList.ui.model

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.newsList.ui.adapter.NewsPagingAdapter

@BindingAdapter("app:pagedList")
fun setPagedList(recyclerView: RecyclerView, pagedList: PagedList<NewsEntity>?) {
    Log.d("Binding", "here $pagedList")
    if (pagedList != null) {
        val adapter = getAdapter(recyclerView)

        adapter.submitList(pagedList)
    }
}

private fun getAdapter(recyclerView: RecyclerView): NewsPagingAdapter {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = NewsPagingAdapter()
    }

    return recyclerView.adapter as NewsPagingAdapter
}