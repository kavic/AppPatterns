package com.kv.patterns.mvp.user

import com.kv.patterns.bean.UserBean

/**
 * Created by tanjunzhao on 5/20/21.
 */
interface UserContract {

    interface Model {

        /**
         * 加载UserBean
         */
        fun loadUser(): UserBean?

        /**
         * 保存UserBean
         */
        fun saveUser(user: UserBean): Boolean

    }

    interface Presenter {

        fun loadUser()

        fun saveUser(account: String?, pwd: String?): Boolean

    }

    interface View : BaseView<Presenter> {

        fun getAccount(): String?

        fun getPwd(): String?

        fun setAccount(account: String?)

        fun setPwd(pwd: String?)

    }
}