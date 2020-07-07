package com.merseyside.news.di

import com.merseyside.core.di.CoreComponent
import com.merseyside.news.application

interface HasCoreComponent {

    val coreComponent: CoreComponent
        get() {
            return application.coreComponent
        }
}