package com.merseyside.core.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.merseyside.core.network.NetworkState
import retrofit2.Response.error

private fun getError(report: PagingRequestHelper.StatusReport): Throwable {
    return PagingRequestHelper.RequestType.values().mapNotNull {
        report.getErrorFor(it)
    }.first()
}

fun PagingRequestHelper.createStatusLiveData(): LiveData<NetworkState> {
    val liveData = MutableLiveData<NetworkState>()
    addListener { report ->
        when {
            report.hasRunning() -> liveData.postValue(NetworkState.Loading)
            report.hasError() -> {
                val error = getError(report)

                liveData.postValue(
                    NetworkState.Error(error, error.message))
            }
            else -> liveData.postValue(NetworkState.Success)
        }
    }
    return liveData
}
