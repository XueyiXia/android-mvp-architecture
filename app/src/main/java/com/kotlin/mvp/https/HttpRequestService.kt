package com.kotlin.mvp.https

import com.kotlin.mvp.https.ApiService
import com.kotlin.mvp.https.HttpRequestService

/**
 * @author: xiaxueyi
 * @date: 2022-11-29
 * @time: 16:51
 * @说明: Http请求服务
 */
object HttpRequestService {
    private var mInstance: ApiService? = null //公共网络请求接口对象

    /**
     * 获取接口对象
     * @return
     */
    val instance: ApiService
        get() {
            if (mInstance == null) {
                mInstance = RetrofitManager.instance.createService(ApiService::class.java)
            }
            return mInstance as ApiService
        }
}