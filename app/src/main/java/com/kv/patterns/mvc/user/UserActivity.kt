package com.kv.patterns.mvc.user

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.kv.patterns.BaseActivity
import com.kv.patterns.MyApplication
import com.kv.patterns.mvp.user.UserPresenter
import com.kv.patterns.util.Constant
import com.kv.patterns.util.SpUtil

/**
 * Created by tanjunzhao on 5/24/21.
 */
class UserActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoreData();
    }

    override fun saveBtnOnClick() {

        val account = accountEt?.text.toString()
        val pwd = pwdEt?.text.toString()

        if (SpUtil.putString(Constant.Object.SP_ACCOUNT, account, MyApplication.context) &&
                SpUtil.putString(Constant.Object.SP_PWD, pwd, MyApplication.context)) {
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show()
        }

    }

    private fun restoreData() {

        val account = SpUtil.getString(Constant.Object.SP_ACCOUNT, this)
        val pwd = SpUtil.getString(Constant.Object.SP_PWD, this)

        account?.let {
            accountEt?.text = Editable.Factory.getInstance().newEditable(account)
        }

        pwd?.let {
            pwdEt?.text = Editable.Factory.getInstance().newEditable(pwd)
        }
    }
}