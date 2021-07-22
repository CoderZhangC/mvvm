package com.wan.android.ui.fragment.home

import com.wan.android.R
import com.wan.android.databinding.FragmentHomeBinding
import com.wan.android.ui.fragment.home.model.HomeViewModel
import com.wan.base.common.BaseDataBindingFragment

/**
 * create an instance of this fragment.
 */
class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel = HomeViewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyInitData() {
        super.lazyInitData()
        homeViewModel.articles.observe(this) {
            mDatabind.btn.text = it[0].superChapterName
        }
        homeViewModel.getHomeArticles()
    }

}