package com.wan.android.ui.fragment.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wan.android.R
import com.wan.android.databinding.FragmentHomeBinding
import com.wan.android.ext.initFooter
import com.wan.android.ext.refreshData
import com.wan.android.ui.adapter.ArticlesAdapter
import com.wan.android.ui.fragment.home.model.HomeViewModel
import com.wan.android.weight.recycleview.SpaceItemDecoration
import com.wan.base.common.BaseDataBindingFragment
import com.wan.base.util.toPx

/**
 * create an instance of this fragment.
 */
class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel = HomeViewModel()
    private val articlesAdapter: ArticlesAdapter = ArticlesAdapter()
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyInitData() {
        super.lazyInitData()
        homeViewModel.getHomeArticles(true)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.includeBaseBar.toolbar.apply {
            title = "首页"
            inflateMenu(R.menu.home_search)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.home_search -> {

                    }
                }
                true
            }
        }
        mDatabind.includeLayoutList.swipeRefreshLayout.setOnRefreshListener {
            homeViewModel.getHomeArticles(true)
        }
        mDatabind.includeLayoutList.homeArticlesRv.apply {
            layoutManager = LinearLayoutManager(activity)
            initFooter {
//                homeViewModel.getHomeArticles(false)
            }
            addItemDecoration(SpaceItemDecoration(0, 8f.toPx(), false))
            adapter = articlesAdapter
        }
        homeViewModel.articles.observe(this) {
            refreshData(
                it,
                mDatabind.includeLayoutList.homeArticlesRv,
                mDatabind.includeLayoutList.swipeRefreshLayout,
                articlesAdapter
            )
        }
    }

}