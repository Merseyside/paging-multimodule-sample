package com.merseyside.newsList.ui.model

import androidx.annotation.AttrRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.merseyside.adapters.base.BasePagedAdapter
import com.merseyside.newsList.BR
import com.merseyside.news.R

class ConnectionViewModel
    : BaseObservable(), BasePagedAdapter.INetworkState {

    private var onRetryListener: BasePagedAdapter.INetworkState.OnRetryListener? = null

    var state: BasePagedAdapter.NetworkState = BasePagedAdapter.NetworkState.CONNECTED

    private var msg: String = ""

    fun setOnRetryListener(listener: BasePagedAdapter.INetworkState.OnRetryListener) {
        this.onRetryListener = listener
    }

    override fun setMessage(msg: String) {
        this.msg = msg
        notifyPropertyChanged(BR.message)
    }

    @Bindable
    fun getMessage(): String {
        return msg
    }

    override fun onStateChanged(state: BasePagedAdapter.NetworkState) {
        this.state = state

        notifyUpdate()
    }

    private fun notifyUpdate() {
        notifyPropertyChanged(BR.networkState)
        notifyPropertyChanged(BR.background)
    }

    @Bindable
    override fun getNetworkState(): BasePagedAdapter.NetworkState {
        return state
    }

    @Bindable
    @AttrRes
    fun getBackground(): Int {
        return when (state) {
            BasePagedAdapter.NetworkState.NO_CONNECTION -> {
                R.attr.colorSecondary
            }
            BasePagedAdapter.NetworkState.LOADING -> {
                R.attr.colorLoading
            }
            BasePagedAdapter.NetworkState.ERROR -> {
                R.attr.colorError
            }

            else -> R.attr.colorPrimary
        }
    }

    fun retry() {
        onRetryListener?.onRetry()
    }

}