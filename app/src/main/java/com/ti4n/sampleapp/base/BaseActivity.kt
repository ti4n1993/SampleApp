package com.ti4n.sampleapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.airbnb.mvrx.MavericksView

abstract class BaseActivity<B : ViewDataBinding>(@LayoutRes layoutId: Int) : AppCompatActivity(),
    MavericksView {

    val dataBinding: B by lazy { DataBindingUtil.setContentView(this, layoutId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dataBinding.root)
        dataBinding.setLifecycleOwner { lifecycle }
    }
}