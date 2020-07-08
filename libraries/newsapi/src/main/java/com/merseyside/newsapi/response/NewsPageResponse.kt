package com.merseyside.newsapi.response

import com.google.gson.annotations.SerializedName
import com.merseyside.newsapi.point.ArticlePoint
import kotlinx.serialization.Serializable

@Serializable
data class NewsPageResponse(

    @SerializedName("status")
    val status: String,

    @SerializedName("articles")
    val articles: List<ArticlePoint> = emptyList()
)