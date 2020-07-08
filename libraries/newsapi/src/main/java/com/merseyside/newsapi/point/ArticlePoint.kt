package com.merseyside.newsapi.point
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlePoint(

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("urlToImage")
    val imageUrl: String?
)