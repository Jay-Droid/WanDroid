package com.jaydroid.main.home.contract

import com.jaydroid.base_component.network.bean.wan.Banner
import com.jaydroid.main.home.bean.Article
import com.jaydroid.base_component.base.mvp.IView


interface HomeContract {
    interface View : IView {

        fun onBanner(list: List<Banner>?)

        fun onArticles(page: Int, list: List<Article>?)
    }

    interface Presenter {

        fun getBanner()

        fun getArticles(page: Int)

    }

}