package com.wan.base.util

import android.app.Application

/**
 * @author ZC
 * @date 2021/7/8
 * desc:
 */
open class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //模拟耗时操作
        ContextUtil.init(this)
        Thread.sleep(1000)
    }
}