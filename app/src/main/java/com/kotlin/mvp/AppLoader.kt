package com.kotlin.mvp

import android.app.Application
import com.kotlin.mvp.https.HttpApi
import com.kotlin.mvp.https.RetrofitManager

/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 12:19
 * @说明:
 */

class AppLoader :Application (){

    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(HttpApi.BASE_URL)
    }
}