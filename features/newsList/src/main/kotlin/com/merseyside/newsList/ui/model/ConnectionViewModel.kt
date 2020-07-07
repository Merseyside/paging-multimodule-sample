package com.merseyside.newsList.ui.model

import androidx.databinding.BaseObservable
import com.merseyside.adapters.base.BasePagedAdapter
import com.merseyside.newsList.BR

class ConnectionViewModel
    : BaseObservable(), BasePagedAdapter.INetworkState {

    var state: BasePagedAdapter.NetworkState = BasePagedAdapter.NetworkState.CONNECTED

    override fun onStateChanged(state: BasePagedAdapter.NetworkState) {
        notifyPropertyChanged(BR.state)
    }

    override fun getNetworkState(): BasePagedAdapter.NetworkState {
        return state
    }

}