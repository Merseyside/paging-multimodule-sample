package com.merseyside.core.network.repository.mapper

import com.merseyside.core.db.news.NewsEntity
import com.merseyside.core.mapper.Mapper
import com.merseyside.newsapi.response.NewsPageResponse
import javax.inject.Inject

class NewsMapper @Inject constructor(): Mapper<Pair<NewsPageResponse, Int>, List<NewsEntity>> {

    override fun map(from: Pair<NewsPageResponse, Int>): List<NewsEntity> {
        return from.first.articles.map {
            NewsEntity(
                page = from.second,
                author = it.author,
                description = it.description,
                url = it.url,
                imageUrl = it.imageUrl,
                title = it.title
            )
        }
    }
}