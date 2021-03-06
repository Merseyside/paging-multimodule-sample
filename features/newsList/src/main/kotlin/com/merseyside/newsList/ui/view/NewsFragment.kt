package com.merseyside.newsList.ui.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.merseyside.adapters.base.onItemClicked
import com.merseyside.commons.ui.base.BaseAppFragment
import com.merseyside.core.db.news.NewsEntity
import com.merseyside.core.network.NetworkState
import com.merseyside.news.BR
import com.merseyside.news.di.HasCoreComponent
import com.merseyside.newsList.R
import com.merseyside.newsList.databinding.FragmentNewsBinding
import com.merseyside.newsList.di.DaggerNewsComponent
import com.merseyside.newsList.di.NewsModule
import com.merseyside.newsList.ui.adapter.NewsPagingAdapter
import com.merseyside.newsList.ui.model.NewsViewModel
import com.merseyside.newsList.utils.openArticle
import com.merseyside.utils.ext.isNotNullAndEmpty

class NewsFragment : BaseAppFragment<FragmentNewsBinding, NewsViewModel>(),
    HasCoreComponent {

    private val adapter = NewsPagingAdapter {
        viewModel.retry()
    }.apply {
        onItemClicked {
             if (it.url.isNotNullAndEmpty()) {
                 openArticle(baseActivity, it.url)
             }
        }
    }

    private val networkObserver = Observer<NetworkState> {
        adapter.setNetworkState(it)
    }

    private val newsObserver = Observer<PagedList<NewsEntity>> {
        adapter.submitList(it)
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun performInjection(bundle: Bundle?) {
        DaggerNewsComponent.builder()
            .coreComponent(coreComponent)
            .newsModule(getNewsModule(bundle))
            .build().inject(this)
    }

    private fun getNewsModule(bundle: Bundle?): NewsModule {
        return NewsModule(this, bundle)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_news
    }

    override fun getTitle(context: Context): String? {
        return getString(R.string.news)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.newsLiveData.observe(viewLifecycleOwner, newsObserver)
        viewModel.networkState.observe(viewLifecycleOwner, networkObserver)

        binding.list.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.newsLiveData.removeObserver(newsObserver)
        viewModel.networkState.removeObserver(networkObserver)
    }
    
}
