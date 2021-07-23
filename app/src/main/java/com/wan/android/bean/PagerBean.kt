package com.wan.android.bean

/**
 * 分页请求后端返回的数据体
 * @param T 实际数据类型
 */
data class PagerBean<T>(
    val curPage: Int,
    val datas: List<T>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int?,
    val total: Int
) {
    fun isEmpty():Boolean = datas.isEmpty()

    /**
     * 是否为刷新
     */
    fun isRefresh() = offset == 0

    /**
     * 是否还有更多数据
     */
    fun hasMore() = !over
}