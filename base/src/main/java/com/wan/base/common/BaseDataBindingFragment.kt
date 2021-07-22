package com.wan.base.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author ZC
 * @date 2021/7/8
 * desc: 使用DataBinding的基类
 */
abstract class BaseDataBindingFragment<DB : ViewDataBinding> : BaseFragment() {

    //该类绑定的ViewDataBinding
    lateinit var mDatabind: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDatabind = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mDatabind.lifecycleOwner = this
        return mDatabind.root
    }
}