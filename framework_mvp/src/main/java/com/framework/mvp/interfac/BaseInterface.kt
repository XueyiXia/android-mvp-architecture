package com.framework.mvp.interfac

import io.reactivex.disposables.Disposable

/**
 * @author: xiaxueyi
 * @date: 2021-10-28
 * @time: 15:11
 * @说明:
 */
interface BaseInterface {
    fun addRequestQueue(disposable: Disposable?)
    fun removeRequestQueue(disposable: Disposable?)
}