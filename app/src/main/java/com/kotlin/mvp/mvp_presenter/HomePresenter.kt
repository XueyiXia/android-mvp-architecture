package com.kotlin.mvp.mvp_presenter

import com.framework.mvp.presenter.BasePresenter
import com.kotlin.mvp.mvp_contract.HomeContract
import com.kotlin.mvp.mvp_model.HomeModel

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
class HomePresenter : BasePresenter<HomeContract.View, HomeContract.Model>(), HomeContract.Presenter {


    override fun createModel(): HomeContract.Model {
        return HomeModel()
    }


    override fun requestHome(pagerNum: Int) {
        mModel.getRequestData(pagerNum)
    }
}