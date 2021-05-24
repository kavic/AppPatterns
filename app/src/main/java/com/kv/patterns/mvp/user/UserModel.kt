package com.kv.patterns.mvp.user

import com.kv.patterns.MyApplication
import com.kv.patterns.bean.UserBean
import com.kv.patterns.util.Constant.Object.SP_ACCOUNT
import com.kv.patterns.util.Constant.Object.SP_PWD
import com.kv.patterns.util.SpUtil

/**
 * Created by tanjunzhao on 5/20/21.
 */
class UserModel : UserContract.Model {

    override fun loadUser(): UserBean? {

        var account = SpUtil.getString(SP_ACCOUNT, MyApplication.context)

        var pwd = SpUtil.getString(SP_PWD, MyApplication.context)

        return UserBean(account, pwd)
    }

    override fun saveUser(user: UserBean): Boolean {

        if (user?.account != null && user.pwd != null) {

            return SpUtil.putString(SP_ACCOUNT, user?.account, MyApplication.context)&&
                    SpUtil.putString(SP_PWD, user?.pwd, MyApplication.context)

        }

        return false

    }

}