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
)