package com.wan.android.ui.fragment.home.model

import androidx.lifecycle.MutableLiveData
import com.wan.android.bean.home.ArticleBean
import com.wan.android.net.apiService
import com.wan.android.net.state.ListDataState
import com.wan.base.common.BaseViewModel

/**
 * @author ZC
 * @date 2021/7/9
 * desc:
 */
class HomeViewModel : BaseViewModel() {

    val articles: MutableLiveData<ListDataState<ArticleBean>> = MutableLiveData()

    var pageNo: Int = 0
    fun getHomeArticles(isRefresh: Boolean) {
        if (isRefresh) {
            pageNo = 0
        }
        val dataState: ListDataState<ArticleBean> = ListDataState()
        if (pageNo == 0) {
            launchWithCatchException({ apiService.getTopArticles() }, {
                dataState.data.addAll(it)
            })
        }
        launchWithCatchException({ apiService.getArticles(pageNo) }, {
            pageNo++
            dataState.apply {
                isSuccess = true
                this.isRefresh = isRefresh
                hasMore = it.hasMore()
                data.addAll(it.datas)
                isFirstEmpty = this.isRefresh && it.isEmpty()
            }
            articles.value = dataState
        })
    }
}