package com.merseyside.news.main.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.merseyside.archy.presentation.activity.BaseBindingActivity
import com.merseyside.news.R
import com.merseyside.news.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun performInjection(bundle: Bundle?) {}

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getToolbar(): Toolbar? {
        return binding.toolbar
    }

    override fun getFragmentContainer(): Int? {
        return null
    }
}