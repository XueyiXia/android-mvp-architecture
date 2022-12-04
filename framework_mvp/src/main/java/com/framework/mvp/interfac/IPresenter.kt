package com.framework.mvp.interfac

/**
 * 用于规范presenter接口
 */
interface IPresenter<V : IView> {
    /**
     * 绑定view
     */
    fun attachView(view: V)

    /**
     * 解绑view
     */
    fun detachView()

    /**
     * 判断view是否绑定
     */
    val isViewAttached: Boolean
}