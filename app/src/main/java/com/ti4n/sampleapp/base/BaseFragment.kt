package com.ti4n.sampleapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.reflect.KClass

open class SimpleFragment<B : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    Fragment() {

    lateinit var dataBinding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return dataBinding.root
    }
}

open class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes layoutId: Int,
    vmClass: KClass<VM>,
    sharedViewModel: Boolean = false
) :
    SimpleFragment<B>(layoutId) {

    protected val viewModel by if (sharedViewModel) activityViewModel(vmClass) else viewModel(
        vmClass
    )
}

@MainThread
fun <VM : ViewModel> Fragment.viewModel(
    vmClass: KClass<VM>,
    ownerProducer: () -> ViewModelStoreOwner = { this },
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
) = createViewModelLazy(vmClass, { ownerProducer().viewModelStore }, factoryProducer)

@MainThread
fun <VM : ViewModel> Fragment.activityViewModel(
    vmClass: KClass<VM>,
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
) = createViewModelLazy(vmClass, { requireActivity().viewModelStore }, factoryProducer)