package com.kotlin.mvp.mvp_contract

import android.content.Context
import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.interfac.IView

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
interface HomeContract {
    interface View : IView {
        fun onSuccess(`object`: Any?)
        fun onLError(`object`: Any?)
    }

    interface Presenter : IPresenter<View> {
        fun requestHome(pagerNum:Int)
    }

    interface Model : IModel {
        fun getRequestData(pagerNum:Int)
    }
}