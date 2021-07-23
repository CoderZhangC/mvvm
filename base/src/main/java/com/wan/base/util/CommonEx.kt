package com.wan.base.util

import android.content.res.Resources

/**
 * @author ZC
 * @date 2021/7/23
 * desc:
 */

fun Float.toPx(): Int{
    val scale = Resources.getSystem().displayMetrics.density
    return (this * scale + 0.5f).toInt()
}