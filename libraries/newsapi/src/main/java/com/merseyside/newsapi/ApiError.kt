package com.merseyside.newsapi

import com.merseyside.utils.serialization.deserialize
import kotlinx.serialization.Serializable

@Serializable
data class APIError private constructor(
    val statusCode: Int = 0,
    val message: String? = null
) {

    companion object {

        fun getError(error: String?): APIError {
            return error?.let {
                deserialize<APIError>()
            } ?: APIError(0, "UnknownError")
        }
    }
}