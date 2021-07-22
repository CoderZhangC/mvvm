package com.wan.base.util

import android.widget.Toast

/**
 * @author ZC
 * @date 2021/7/22
 * desc:
 */
object ToastUtil {

    fun showToast(msg: String) {
        Toast.makeText(ContextUtil.getContext(), msg, Toast.LENGTH_LONG).show()
    }
}