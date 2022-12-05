package com.google.mvp.https;


import com.google.mvp.bean.XyHomeIndex;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author: xiaxueyi
 * @date: 2021-10-29
 * @time: 16:31
 * @说明: 公共网络请求接口Api，service表示的是接口，相当于把接口作为参数传进来，HTTP_SPLICE相当于请求的接口
 */

public interface ApiService {

    @POST(HttpApi.HTTP_SPLICE)
    Observable<Response<String>> getTest(
            @Query("Authorization") String service,
            @QueryMap Map<String, String> map

    );



    @POST(HttpApi.HOME_INDEX)  //首页数据
    @FormUrlEncoded
    Observable<BaseRes<List<XyHomeIndex>>> getHomePageInfo(
            @Field("fposition") int fposition
    );


    @POST(HttpApi.HOME_INDEX)  //首页数据
    @FormUrlEncoded
    Observable<Response<String>> getTest(
            @Field("fposition") int fposition
    );
}
