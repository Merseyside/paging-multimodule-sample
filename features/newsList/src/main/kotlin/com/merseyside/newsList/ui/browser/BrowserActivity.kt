package com.merseyside.newsList.ui.browser

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar
import com.merseyside.archy.presentation.activity.BaseActivity
import com.merseyside.newsList.R


class BrowserActivity : BaseActivity() {

    private lateinit var webView: WebView

    override fun getLayoutId(): Int {
        return R.layout.activity_browser
    }

    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun getFragmentContainer(): Int? {
        return null
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration) {
        if (Build.VERSION.SDK_INT in 21..24) {
            overrideConfiguration.uiMode =
                overrideConfiguration.uiMode and Configuration.UI_MODE_NIGHT_MASK.inv()
        }
        super.applyOverrideConfiguration(overrideConfiguration)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = findViewById(R.id.webView)

        webView.webViewClient = WebViewClient()
        //webView.webChromeClient = WebChromeClient()

        val webSettings: WebSettings = webView.settings
        //webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.setSupportZoom(true)
        webSettings.defaultTextEncodingName = "utf-8"


        if (intent.extras?.containsKey(URI_KEY) == true) {

            val uri = intent.extras!!.getString(URI_KEY)
            webView.loadUrl(uri)
        }
    }

    override fun onStop() {
        super.onStop()

        webView.clearCache(true)
        webView.clearHistory()
    }

    override fun performInjection(bundle: Bundle?) {}

    companion object {
        private const val URI_KEY = "uri"

        fun getIntent(activity: Activity, uri: String): Intent {
            return Intent(activity, BrowserActivity::class.java).apply {
                putExtra(URI_KEY, uri)
            }
        }
    }
}