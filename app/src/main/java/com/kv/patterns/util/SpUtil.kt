package com.kv.patterns.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

/**
 * Created by tanjunzhao on 5/20/21.
 */
object SpUtil {

    private var sps: SharedPreferences? = null

    private fun getSps(context: Context): SharedPreferences {
        if (sps == null) {
            sps = context.getSharedPreferences("default", Context.MODE_PRIVATE)
        }
        return sps!!
    }

    fun putString(key: String, value: String?, context: Context):Boolean {
        if (!value.isNullOrBlank()) {
            var editor: SharedPreferences.Editor = getSps(context).edit()
            editor.putString(key, value)
            return editor.commit()
        }
        return false
    }

    fun getString(key: String, context: Context): String? {
        if (!key.isNullOrBlank()) {
            var sps: SharedPreferences = getSps(context)
            return sps.getString(key, null)
        }
        return null
    }

}