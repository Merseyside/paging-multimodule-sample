package com.merseyside.template.main.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.merseyside.android_template.R
import com.merseyside.android_template.databinding.ActivityMainBinding
import com.merseyside.archy.presentation.activity.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {


    override fun performInjection(bundle: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getToolbar(): Toolbar? {
        TODO("Not yet implemented")
    }

    override fun getFragmentContainer(): Int? {
        TODO("Not yet implemented")
    }
}