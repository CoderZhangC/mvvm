package com.wan.android.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.wan.android.R
import com.wan.android.databinding.FragmentMainBinding
import com.wan.base.common.BaseDataBindingFragment


/**
 * 首页fragment
 */
class MainFragment : BaseDataBindingFragment<FragmentMainBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mDatabind.mainViewPager.apply {
            offscreenPageLimit = 5//滑动是Fragment数据会丢失
            isUserInputEnabled = false
            adapter = object : FragmentStateAdapter(this@MainFragment) {
                override fun getItemCount(): Int = 5

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> HomeFragment()
                        1 -> ProjectFragment()
                        2 -> SquareFragment()
                        3 -> WeChatFragment()
                        else -> MineFragment()
                    }
                }

            }
        }
        //当底部选项超过三哥，默认未选中的文字不显示
        mDatabind.mainBottom.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        mDatabind.mainBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> mDatabind.mainViewPager.currentItem = 0
                R.id.action_project -> mDatabind.mainViewPager.currentItem = 1
                R.id.action_square -> mDatabind.mainViewPager.currentItem = 2
                R.id.action_we_chat -> mDatabind.mainViewPager.currentItem = 3
                R.id.action_mine -> mDatabind.mainViewPager.currentItem = 4
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

}