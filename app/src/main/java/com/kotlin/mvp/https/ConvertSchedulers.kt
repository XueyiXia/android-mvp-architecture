package com.kotlin.mvp.https

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author: xiaxueyi
 * @date: 2017-12-01
 * @time: 13:52
 * @说明: 订阅者转换器
 */
object ConvertSchedulers{
    fun<T> convertSchedulers() : ObservableTransformer<T, T> {

        return ObservableTransformer{
            it.
            subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread(), true)
        }

    }
}
