package com.merseyside.commons.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.merseyside.archy.presentation.model.BaseViewModel
import com.merseyside.archy.presentation.fragment.BaseVMFragment

abstract class BaseAppFragment<B : ViewDataBinding, M : BaseViewModel> : BaseVMFragment<B, M>() {

}
