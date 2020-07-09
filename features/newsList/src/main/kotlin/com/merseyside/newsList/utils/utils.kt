package com.merseyside.newsList.utils

import android.app.Activity
import com.merseyside.newsList.ui.browser.BrowserActivity

fun openArticle(activity: Activity, uri: String) {
    activity.startActivity(BrowserActivity.getIntent(activity, uri))
}