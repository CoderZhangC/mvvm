package com.wan.android.net

import com.wan.base.net.BaseNetworkApi
import com.wan.base.net.LogInterceptor
import okhttp3.OkHttpClient

/**
 * @author ZC
 * @date 2021/7/9
 * desc:
 */
//双重校验锁式-单例 封装NetApiService 方便直接快速调用简单的接口
val apiService: ApiService by lazy {
    NetWorkApi.INSTANCE.getApi(ApiService::class.java, ApiService.BASE_URL)
}

class NetWorkApi : BaseNetworkApi() {

    companion object {
        val INSTANCE: NetWorkApi by lazy {
            NetWorkApi()
        }
    }

    override fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder.apply {
            // 日志拦截器
            addInterceptor(LogInterceptor())
        }
    }
}