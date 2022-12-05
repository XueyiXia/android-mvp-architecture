package com.kotlin.mvp.https

import com.kotlin.mvp.bean.HomeBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.*

/**
 * @author: xiaxueyi
 * @date: 2021-10-29
 * @time: 16:31
 * @说明: 公共网络请求接口Api，service表示的是接口，相当于把接口作为参数传进来，HTTP_SPLICE相当于请求的接口
 */
interface ApiService {


    @GET(HttpApi.HOME_INDEX)
    fun getFirstHomeData(@Query("num") num:Int): Observable<HomeBean>
}