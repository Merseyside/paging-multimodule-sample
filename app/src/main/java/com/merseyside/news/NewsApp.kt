package com.merseyside.news

import com.merseyside.archy.BaseApplication
import com.merseyside.core.di.CoreComponent
import com.merseyside.core.di.DaggerCoreComponent
import com.merseyside.core.di.modules.ContextModule
import javax.inject.Inject

class NewsApp : BaseApplication() {

    lateinit var coreComponent: CoreComponent

    companion object {
        private lateinit var application : NewsApp

        fun getInstance(): NewsApp = application

        fun getCoreCompomponent(): CoreComponent
            = getInstance().coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        initCoreDependencyInjection()
        //initAppDependencyInjection()
    }

//    private fun initAppDependencyInjection() {
//        DaggerAppComponent
//            .builder()
//            .coreComponent(coreComponent)
//            .build().inject(this)
//    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }
}