package com.framework.mvp

import com.framework.mvp.interfac.BaseView
import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
interface EmptyContract {
    interface View : BaseView {
        fun onSuccess(bean: Any)
        fun onLError(`object`: Any?)
    }

    interface Presenter : IPresenter<View> {
        fun requestHome()
    }

    interface Model : IModel {
        fun getEmptyData()
    }
}