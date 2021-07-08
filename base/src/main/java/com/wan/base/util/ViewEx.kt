package com.wan.base.util

import android.view.View

/**
 * @author ZC
 * @date 2021/7/5
 * desc:
 */
fun View.setVisibleOrGone(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}