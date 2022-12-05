package com.google.mvp.mvp_presenter;


import android.content.Context;
import android.util.Log;

import com.google.mvp.bean.XyHomeIndex;
import com.google.mvp.https.BaseRes;
import com.google.mvp.mvp_contract.AllOrderApplicationListContract;
import com.google.mvp.mvp_model.AllOrderApplicationListModel;
import com.google.mvp.https.NetSubscription;
import com.framework.enumtype.DialogType;
import com.framework.exception.ApiServerException;
import com.framework.interfac.SimpleResponseListener;
import com.framework.mvp.BasePresenter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
public class AllOrderApplicationListPresenter extends BasePresenter<AllOrderApplicationListContract.View, AllOrderApplicationListContract.Model> implements AllOrderApplicationListContract.Presenter {


    @Override
    public AllOrderApplicationListContract.Model createModel() {
        return new AllOrderApplicationListModel();
    }

    @Override
    public boolean useEventBus() {
        return false;
    }


    @Override
    public void request(Context context,HashMap<String, String> hashMap) {
        Observable<BaseRes<List<XyHomeIndex>>> observable=mModel.queryAllOrderApplicationList(context,hashMap);
        NetSubscription.subscription(mView.getContext(),this,  observable,XyHomeIndex.class, DialogType.NORMAL_LOADING, new SimpleResponseListener<BaseRes<List<XyHomeIndex>>>() {
            @Override
            public void onSucceed(BaseRes<List<XyHomeIndex>> response, String method) {
                Log.e("Presenter",response.getData().toString());
                mView.onSuccess(response.toString());
                super.onSucceed(response, method);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(ApiServerException exception) {
                mView.onLError(exception);
                super.onError(exception);
            }
        });

//        DisposableObserver observer = new ProgressObserver(context,String.class, DialogType.FORBID_LOADING, new SimpleResponseListener<Response<String>>(){
//
//            @Override
//            public void onSucceed(Response<String> data, String method) {
//                super.onSucceed(data, method);
//                Log.e("Presenter",data.body());
//
//                Log.e("Presenter",data.toString());
//
//            }
//
//            @Override
//            public void onCompleted() {
//                super.onCompleted();
//                Log.e("Presenter","onCompleted");
//            }
//
//            @Override
//            public void onError(ApiServerException exception) {
//                super.onError(exception);
//                Log.e("Presenter",exception.toString());
//            }
//        });
//
//        this.addDisposable(observer);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
    }
}
