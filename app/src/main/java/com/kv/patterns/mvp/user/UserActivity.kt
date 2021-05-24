package com.kv.patterns.mvp.user

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.kv.patterns.BaseActivity


class UserActivity : BaseActivity(), UserContract.View {

    private var mPresenter: UserContract.Presenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = UserPresenter(this)
        mPresenter?.loadUser();
    }


    override fun saveBtnOnClick() {

        if(mPresenter?.saveUser(getAccount(), getPwd())!!){
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getAccount(): String? {
        return accountEt?.text.toString()
    }

    override fun getPwd(): String? {
        return pwdEt?.text.toString()
    }

    override fun setAccount(account: String?) {
        if (!account.isNullOrBlank())
            accountEt?.text = Editable.Factory.getInstance().newEditable(account)

    }

    override fun setPwd(pwd: String?) {
        if (!pwd.isNullOrBlank())
            pwdEt?.text = Editable.Factory.getInstance().newEditable(pwd)
    }

    override fun setPresenter(presenter: UserContract.Presenter) {
        mPresenter = presenter
    }
}