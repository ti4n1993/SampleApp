package com.ti4n.sampleapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<B : ViewDataBinding>(@LayoutRes layoutId: Int) : AppCompatActivity() {

    val dataBinding: B by lazy { DataBindingUtil.setContentView(this, layoutId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dataBinding.root)
        dataBinding.setLifecycleOwner { lifecycle }
    }
}