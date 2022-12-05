package com.kotlin.mvp.mvp_contract

import android.content.Context
import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.interfac.IView
import com.kotlin.mvp.bean.TestBean
import com.kotlin.mvp.https.BaseRes
import io.reactivex.Observable

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
interface TestContract {
    interface View : IView {
        fun onSuccess(`object`: Any?)
        fun onLError(`object`: Any?)
    }

    interface Presenter : IPresenter<View> {
        fun request(context: Context, hashMap: HashMap<String, String>)
    }

    interface Model : IModel {
        fun getRequestData(
            context: Context,
            hashMap: HashMap<String, String>
        ): Observable<BaseRes<List<TestBean>>>
    }
}