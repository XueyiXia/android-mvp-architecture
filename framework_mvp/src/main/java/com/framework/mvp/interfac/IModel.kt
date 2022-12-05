package com.framework.mvp.interfac

import io.reactivex.disposables.Disposable

/**
 * 用于规范model接口
 */
interface IModel {
    /**
     * 管理订阅关系
     * @param disposable
     */
    fun addDisposable(disposable: Disposable)

    /**
     * 解绑订阅关系
     */
    fun onDetach()
}