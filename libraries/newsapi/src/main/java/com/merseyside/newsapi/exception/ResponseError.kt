package com.merseyside.newsapi.exception

import com.merseyside.utils.serialization.deserialize
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import retrofit2.Response
import java.io.IOException

@Serializable
data class ResponseError private constructor(
    override val message: String = "No message"
): IOException() {

    @Transient
    var code: Int = 0
        private set

    companion object {
        fun getError(response: Response<*>): ResponseError {
            val code = response.code()

            val error = response.errorBody()?.string()?.deserialize()
                ?: ResponseError().apply { this.code = code }

            error.code = code

            return error
        }
    }
}