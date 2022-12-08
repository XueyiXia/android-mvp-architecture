package com.kotlin.mvp.mvp_model

import com.framework.mvp.mode.BaseModel
import com.framework.mvp.scheduler.SchedulerUtils
import com.kotlin.mvp.bean.HomeBean
import com.kotlin.mvp.https.HttpRequestService
import com.kotlin.mvp.https.HttpResponseObserver
import com.kotlin.mvp.interfac.SimpleResponseListener
import com.kotlin.mvp.mvp_contract.HomeContract

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
class HomeModel : BaseModel(), HomeContract.Model {


    override fun getRequestData(pagerNum: Int,simpleResponseListener: SimpleResponseListener<HomeBean>) {
        val test=object : HttpResponseObserver<HomeBean>(object:SimpleResponseListener<HomeBean>(){

            override fun onSucceed(data: HomeBean, method: String) {
                super.onSucceed(data, method)

            }

            override fun onCompleted() {
                super.onCompleted()
            }

            override fun onError(exception: Throwable?) {
                super.onError(exception)
            }
        }){


        }
        HttpRequestService.instance.getFirstHomeData(1)
            .compose(SchedulerUtils.ioToMain())
            .subscribe(HttpResponseObserver(simpleResponseListener))

    }
}

