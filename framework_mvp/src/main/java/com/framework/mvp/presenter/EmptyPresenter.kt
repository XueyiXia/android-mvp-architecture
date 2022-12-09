package com.framework.mvp.presenter

import com.framework.mvp.EmptyContract
import com.framework.mvp.mode.EmptyModel


/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
class EmptyPresenter : BasePresenter<EmptyContract.View, EmptyContract.Model>(), EmptyContract.Presenter {


    override fun createModel(): EmptyContract.Model {
        return EmptyModel()
    }

    override fun requestHome() {

    }
}