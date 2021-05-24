package com.kv.patterns.mvp.user

/**
 * Created by tanjunzhao on 5/21/21.
 */
interface BaseView<T> {

    fun setPresenter(presenter: T)

}