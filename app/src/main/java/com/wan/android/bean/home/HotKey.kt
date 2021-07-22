package com.wan.android.bean.home

/**
 * 搜索热词
 */
data class HotKey(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)