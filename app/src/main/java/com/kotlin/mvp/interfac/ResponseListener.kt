package com.kotlin.mvp.interfac

/**
 * @author: xiaxueyi
 * @date: 2017-11-30
 * @time: 09:16
 * @说明: 服务器数据返回监听
 */
interface ResponseListener<T> {
    fun onSucceed(data: T, method: String) //成功的时候回调
    fun onCompleted() //完成的时候回调,不管成功与否，观察者都结束
    fun onError(exception: Throwable?) //发生错误的时候回调
}