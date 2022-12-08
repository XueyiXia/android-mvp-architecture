package com.kotlin.mvp.mvp_contract

import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.interfac.BaseView
import com.kotlin.mvp.bean.HomeBean
import com.kotlin.mvp.interfac.SimpleResponseListener

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
interface HomeContract {
    interface View : BaseView {
        fun onSuccess(bean: HomeBean)
        fun onLError(`object`: Any?)
    }

    interface Presenter : IPresenter<View> {
        fun requestHome(pagerNum:Int)
    }

    interface Model : IModel {
        fun getRequestData(pagerNum:Int,simpleResponseListener: SimpleResponseListener<HomeBean>)
    }
}