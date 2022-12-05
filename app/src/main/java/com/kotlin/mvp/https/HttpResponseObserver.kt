package com.kotlin.mvp.https

import com.kotlin.mvp.interfac.SimpleResponseListener
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 13:11
 * @说明: 观察者;回调处理
 */

class HttpResponseObserver<T> constructor( private val mResponseListener: SimpleResponseListener<T>? = null): Observer<T>{

    private var disposable: Disposable? = null//接触订阅

    private val method: String? = null //缓存的方法名，其实就是一个 key值

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        mResponseListener?.onSucceed(t, method.toString())
    }

    override fun onError(e: Throwable) {
        mResponseListener?.onError(e)
    }

    override fun onComplete() {
        mResponseListener?.onCompleted()
    }


    /**
     * 退出订阅
     */
    private fun onCancel() {
        if (!disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }
}