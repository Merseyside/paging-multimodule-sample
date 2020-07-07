package com.merseyside.newsList.ui.view

import android.content.Context
import android.os.Bundle
import com.merseyside.commons.ui.base.BaseAppFragment
import com.merseyside.news.BR
import com.merseyside.news.di.HasCoreComponent
import com.merseyside.newsList.R
import com.merseyside.newsList.databinding.FragmentNewsBinding
import com.merseyside.newsList.di.DaggerNewsComponent
import com.merseyside.newsList.di.NewsModule
import com.merseyside.newsList.ui.model.NewsViewModel

class NewsFragment : BaseAppFragment<FragmentNewsBinding, NewsViewModel>(),
    HasCoreComponent {

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
        return getString(R.string.title)
    }
    
}
