package com.wan.base.net.interceptor

import com.wan.base.net.AppException

/**
 * @author ZC
 * @date 2021/7/22
 * desc:
 */
class ApiException(errorCode: Int, errorMsg: String) : AppException(errorCode, errorMsg)