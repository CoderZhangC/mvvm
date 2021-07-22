package com.wan.android.net

import com.wan.android.bean.ApiResponse
import com.wan.android.bean.PagerBean
import com.wan.android.bean.home.ArticleBean
import com.wan.android.bean.home.Friend
import com.wan.android.bean.home.HomeBannerBean
import com.wan.android.bean.home.HotKey
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author ZC
 * @date 2021/7/8
 * desc:
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://wanandroid.com/"
    }

    /**
     * 首页文章
     */
    @GET("article/list/{page}/json")
    suspend fun getArticles(@Path("page") page: Int): ApiResponse<PagerBean<ArticleBean>>

    /**
     * 置顶文章
     */
    @GET("article/top/json")
    suspend fun getTopArticles(): ApiResponse<List<ArticleBean>>

    /**
     * 首页轮播图
     */
    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<List<HomeBannerBean>>

    /**
     * 首页轮播图
     */
    @GET("friend/json")
    suspend fun getFriend(): ApiResponse<List<Friend>>

    /**
     * 搜索热词
     */
    @GET("hotkey/json")
    suspend fun getHotKey(): ApiResponse<List<HotKey>>

}