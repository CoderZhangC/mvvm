package com.wan.base.net

/**
 * desc:请求成功但是返回数据体状态报错抛出此异常
 */
open class AppException(val errorCode: Int, val errorMsg: String) : Exception()