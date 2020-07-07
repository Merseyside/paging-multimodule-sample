package com.merseyside.core.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.merseyside.core.network.NetworkState

private fun getErrorMessage(report: PagingRequestHelper.StatusReport): String {
    return PagingRequestHelper.RequestType.values().mapNotNull {
        report.getErrorFor(it)?.message
    }.first()
}

fun PagingRequestHelper.createStatusLiveData(): LiveData<NetworkState> {
    val liveData = MutableLiveData<NetworkState>()
    addListener { report ->
        when {
            report.hasRunning() -> liveData.postValue(NetworkState.Loading)
            report.hasError() -> liveData.postValue(
                report.getErrorFor(PagingRequestHelper.RequestType.INITIAL)?.let {
                    NetworkState.Error(
                        it, getErrorMessage(report))
                })
            else -> liveData.postValue(NetworkState.Success)
        }
    }
    return liveData
}
