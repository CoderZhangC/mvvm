package com.wan.base.net

import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author ZC
 * @date 2021/7/9
 * desc:
 */
abstract class BaseNetworkApi {

    fun <T> getApi(service: Class<T>, baseUrl: String): T {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitBuilder.create(service)
    }

    /**
     * 实现重写父类的setHttpClientBuilder方法，
     * 在这里可以添加拦截器，可以对 OkHttpClient.Builder 做任意操作
     */
    abstract fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder

    /**
     * 配置http
     */
    private val okHttpClient: OkHttpClient
        get() {
            var builder = RetrofitUrlManager.getInstance().with(OkHttpClient.Builder())
            builder = setHttpClientBuilder(builder)
            return builder.build()
        }
}