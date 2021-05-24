package com.kv.patterns

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * Created by tanjunzhao on 5/20/21.
 */
class MyApplication : Application() {

    companion object {

        private val TAG = "com.kv.patterns.MyApplication"

        var context: Context by Delegates.notNull()
            private set

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}