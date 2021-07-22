package com.wan.android.bean

import com.wan.base.net.AppException
import com.wan.base.net.BaseResp
import com.wan.base.net.interceptor.ApiException

/**
 * @author ZC
 * @date 2021/7/8
 * desc:请求成功后返回的数据体
 */
data class ApiResponse<T>(val errorCode: Int, val errorMsg: String, val data: T) : BaseResp<T>() {

    /**
     * 根据errorCode判断请求是否成功
     * @return true表示成功
     */
    override fun requestSuccess(): Boolean = errorCode == 0

    override fun getRespCode(): Int = errorCode

    override fun getRespData(): T {
        if (requestSuccess()) {
            return data
        }
        throw ApiException(getRespCode(), getRespMsg())
    }

    override fun getRespMsg(): String = errorMsg
}