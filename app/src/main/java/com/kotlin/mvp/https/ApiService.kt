package com.kotlin.mvp.https

import com.kotlin.mvp.bean.TestBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

/**
 * @author: xiaxueyi
 * @date: 2021-10-29
 * @time: 16:31
 * @说明: 公共网络请求接口Api，service表示的是接口，相当于把接口作为参数传进来，HTTP_SPLICE相当于请求的接口
 */
interface ApiService {
    @POST(HttpApi.Companion.HTTP_SPLICE)
    fun getTest(
        @Query("Authorization") service: String?,
        @QueryMap map: Map<String?, String?>?
    ): Observable<Response<String?>?>?

    @POST(HttpApi.Companion.HOME_INDEX) //首页数据
    @FormUrlEncoded
    fun getHomePageInfo(
        @Field("fposition") fposition: Int
    ): Observable<BaseRes<List<TestBean?>?>?>?

    @POST(HttpApi.Companion.HOME_INDEX) //首页数据
    @FormUrlEncoded
    fun getTest(
        @Field("fposition") fposition: Int
    ): Observable<Response<String?>?>?
}