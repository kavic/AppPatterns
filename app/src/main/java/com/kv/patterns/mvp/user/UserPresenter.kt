package com.kv.patterns.mvp.user

import com.kv.patterns.bean.UserBean

/**
 * Created by tanjunzhao on 5/21/21.
 */
class UserPresenter : UserContract.Presenter {

    private var mView: UserContract.View? = null

    private var mModel: UserContract.Model? = null


    constructor(view: UserContract.View) {
        this.mView = view
        this.mModel = UserModel()
    }


    override fun loadUser() {
        val userBean = mModel?.loadUser()
        mView?.setAccount(userBean?.account)
        mView?.setPwd(userBean?.pwd)
    }

    override fun saveUser(account: String?, pwd: String?): Boolean {
        return mModel?.saveUser(UserBean(account, pwd))!!
    }

}