package com.wan.base.common

import android.net.ParseException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import com.wan.base.net.AppException
import com.wan.base.net.BaseResp
import com.wan.base.net.interceptor.ApiException
import com.wan.base.util.ToastUtil
import kotlinx.coroutines.launch
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

/**
 * @author ZC
 * @date 2021/7/9
 * desc:
 */
open class BaseViewModel : ViewModel() {

    /**
     *
     * @param error 请求失败回调，默认不传
     */
    fun <T> launchWithCatchException(
        block: suspend () -> BaseResp<T>,
        success: (T) -> Unit,
        error: (AppException) -> Unit = {}
    ) {
        viewModelScope.launch {
            kotlin.runCatching {
                block()
            }.onSuccess {
                success.invoke(it.getRespData())
            }.onFailure {
                val handleException = handleException(it)
                ToastUtil.showToast(handleException.errorMsg)
                error(handleException)
            }
        }
    }

    open fun handleException(exception: Throwable): AppException {
        return when (exception) {
            is HttpException -> {
                AppException(1007, "网络错误")
            }
            is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                AppException(1005, "数据解析错误")
            }
            is ConnectException -> {
                AppException(1004, "网络连接错误")
            }
            is javax.net.ssl.SSLException -> {
                AppException(1003, "证书有误")
            }
            is java.net.SocketTimeoutException -> {
                AppException(1002, "连接超时")
            }
            is java.net.UnknownHostException -> {
                AppException(1001, "域名解析错误")
            }
            is ApiException -> return exception

            else -> {
                AppException(1000, "未知错误")
            }
        }
    }
}