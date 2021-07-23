package com.wan.android.ui.adapter

import android.annotation.SuppressLint
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.wan.android.R
import com.wan.android.bean.home.ArticleBean
import com.wan.android.databinding.ItemArticleBinding
import com.wan.base.util.setVisibleOrGone

/**
 * @author ZC
 * @date 2021/7/22
 * desc:
 */
class ArticlesAdapter :
    BaseQuickAdapter<ArticleBean, BaseDataBindingHolder<ItemArticleBinding>>(R.layout.item_article) {

    @SuppressLint("SetTextI18n")
    override fun convert(holder: BaseDataBindingHolder<ItemArticleBinding>, item: ArticleBean) {
        val dataBinding = holder.dataBinding!!
        dataBinding.bean = item
        dataBinding.author.text = if (item.author.isNotEmpty()) item.author else item.shareUser
        dataBinding.source.text = "${item.superChapterName}·${item.chapterName}"
        //展示标签
        dataBinding.tagNew.setVisibleOrGone(item.fresh)
        dataBinding.tagTop.setVisibleOrGone(item.type == 1)
        dataBinding.tagSource.setVisibleOrGone(item.tags.isNotEmpty())
        if (item.tags.isNotEmpty()) {
            dataBinding.tagSource.text = item.tags[0].name
        }
    }
}