package com.kotlin.mvp.interfac

/**
 * @author: xiaxueyi
 * @date: 2021-10-23
 * @time: 09:15
 * @说明: 服务器数据回调,
 */
abstract class SimpleResponseListener<T> : ResponseListener<T> {

    override fun onSucceed(data: T, method: String) {

    }

    override fun onCompleted() {

    }


    override fun onError(exception: Throwable?) {

    }
}