package com.wan.android.ui.fragment.home.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wan.android.bean.home.ArticleBean
import com.wan.android.net.apiService
import com.wan.base.common.BaseViewModel
import kotlinx.coroutines.launch

/**
 * @author ZC
 * @date 2021/7/9
 * desc:
 */
class HomeViewModel : BaseViewModel() {

    val articles: MutableLiveData<List<ArticleBean>> = MutableLiveData()

    fun getHomeArticles() {
       launchWithCatchException({apiService.getArticles(0)}, {
           articles.value = it.datas
       })
    }
}