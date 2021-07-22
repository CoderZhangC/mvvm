package com.wan.base.util

import android.content.Context

/**
 * @author ZC
 * @date 2021/7/22
 * desc:
 */
object ContextUtil {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    fun getContext():Context {
        return context
    }
}