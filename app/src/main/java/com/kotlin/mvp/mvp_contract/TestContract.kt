package com.kotlin.mvp.mvp_contract;


import android.content.Context;

import com.framework.mvp.interfac.IModel;
import com.framework.mvp.interfac.IPresenter;
import com.framework.mvp.interfac.IView;
import com.kotlin.mvp.bean.TestBean;
import com.kotlin.mvp.https.BaseRes;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
public interface TestContract {


    interface View extends IView {

        void onSuccess(Object object);

        void onLError(Object object);
    }

    interface Presenter extends IPresenter<View> {
        void request(Context context,HashMap<String,String> hashMap);
    }

    interface Model extends IModel {

        Observable<BaseRes<List<TestBean>>> getRequestData(Context context, HashMap<String, String> hashMap);
    }

}
