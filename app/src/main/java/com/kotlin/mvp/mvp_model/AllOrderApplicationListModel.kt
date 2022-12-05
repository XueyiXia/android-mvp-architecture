package com.google.mvp.mvp_model;

import android.content.Context;

import com.google.mvp.bean.XyHomeIndex;
import com.google.mvp.https.ApiService;
import com.google.mvp.https.BaseRes;
import com.google.mvp.https.HttpRequestService;
import com.google.mvp.mvp_contract.AllOrderApplicationListContract;
import com.framework.mvp.BaseModel;
import com.google.gson.Gson;
import com.google.mvp.utils.GsonUtils;


import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;

/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
public class AllOrderApplicationListModel extends BaseModel implements AllOrderApplicationListContract.Model {

    private ApiService mNetApi;

    public AllOrderApplicationListModel(){
        mNetApi = HttpRequestService.getInstance();
    }


    @Override
    public Observable<BaseRes<List<XyHomeIndex>>> queryAllOrderApplicationList(Context context, HashMap<String, String> hashMap) {
        String strEntity = GsonUtils.toJson(hashMap);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
        return mNetApi.getHomePageInfo(1);
    }


}
