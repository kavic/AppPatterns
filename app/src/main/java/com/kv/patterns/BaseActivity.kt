package com.kv.patterns

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kv.patterns.mvp.user.UserContract
import com.kv.patterns.mvp.user.UserPresenter

/**
 * Created by tanjunzhao on 5/24/21.
 */
open abstract class BaseActivity : AppCompatActivity() {

    protected var saveBtn: Button? = null
    protected var accountEt: EditText? = null
    protected var pwdEt: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_user)
        initView()
    }

    private fun initView() {
        saveBtn = findViewById(R.id.btn_save)
        accountEt = findViewById(R.id.edt_account)
        pwdEt = findViewById(R.id.edt_pwd)
        saveBtn?.setOnClickListener {
            saveBtnOnClick()
        }

    }

    abstract fun saveBtnOnClick();

}