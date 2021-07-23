package com.wan.android.ext

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.wan.android.net.state.ListDataState
import com.wan.android.weight.recycleview.DefineLoadMoreView
import com.wan.base.util.ContextUtil
import com.yanzhenjie.recyclerview.SwipeRecyclerView

/**
 * @author ZC
 * @date 2021/7/23
 * desc:
 */

fun SwipeRecyclerView.initFooter(loadmoreListener: SwipeRecyclerView.LoadMoreListener): DefineLoadMoreView {
    val footerView = DefineLoadMoreView(ContextUtil.getContext())
    //给尾部设置颜色
//    footerView.setLoadViewColor(SettingUtil.getOneColorStateList(appContext))
    //设置尾部点击回调
    footerView.setmLoadMoreListener(SwipeRecyclerView.LoadMoreListener {
        footerView.onLoading()
        loadmoreListener.onLoadMore()
    })
    this.run {
        //添加加载更多尾部
        addFooterView(footerView)
        setLoadMoreView(footerView)
        //设置加载更多回调
        setLoadMoreListener(loadmoreListener)
    }
    return footerView
}

/**
 * 列表页面请求数据后统一调用方法刷新UI
 */
fun <T> refreshData(
    listDataState: ListDataState<T>,
    swipeRecyclerView: SwipeRecyclerView,
    swipeRefreshLayout: SwipeRefreshLayout,
    baseQuickAdapter: BaseQuickAdapter<T, *>
) {
    swipeRefreshLayout.isRefreshing = false
    swipeRecyclerView.loadMoreFinish(false, listDataState.hasMore)
    if (listDataState.isSuccess) {
        if (listDataState.isRefresh) {
            baseQuickAdapter.setList(listDataState.data)
        } else {
            baseQuickAdapter.addData(listDataState.data)
        }
    }
}