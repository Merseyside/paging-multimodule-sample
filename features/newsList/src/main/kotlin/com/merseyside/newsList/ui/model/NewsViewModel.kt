package com.merseyside.newsList.ui.model

import android.content.Context
import com.merseyside.commons.ui.base.BaseAppViewModel
import com.merseyside.news.application

class NewsViewModel : BaseAppViewModel() {

    override fun getLocaleContext(): Context {
        return application
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }
}
