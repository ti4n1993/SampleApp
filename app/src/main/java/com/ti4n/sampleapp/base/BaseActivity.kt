package com.ti4n.sampleapp.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

open class SimpleActivity<B : ViewDataBinding>(@LayoutRes layoutId: Int) : AppCompatActivity() {

    protected val dataBinding: B by lazy { DataBindingUtil.setContentView(this, layoutId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.lifecycleOwner = this
    }
}

open class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes layoutId: Int,
    vmClass: KClass<VM>
) :
    SimpleActivity<B>(layoutId) {

    protected val viewModel by viewModel(vmClass)
}

@MainThread
fun <VM : ViewModel> ComponentActivity.viewModel(
    vmClass: KClass<VM>,
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> {
    val factoryPromise = factoryProducer ?: {
        defaultViewModelProviderFactory
    }

    return ViewModelLazy(vmClass, { viewModelStore }, factoryPromise)
}