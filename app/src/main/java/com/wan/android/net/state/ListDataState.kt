package com.wan.android.net.state

/**
 * @author ZC
 * @date 2021/7/23
 * desc:列表数据状态类
 */
class ListDataState<T>(
    var isSuccess: Boolean = true,
    //分页加载控制数据以何种方式添加
    var isRefresh: Boolean = true,
    var data: MutableList<T> = mutableListOf(),
    //请求失败对应的错误信息
    var errorMsg: String = "",
    //控制空布局显示
    var isFirstEmpty: Boolean = false,
    //分页加载是否还能加载更多
    var hasMore: Boolean = true
)