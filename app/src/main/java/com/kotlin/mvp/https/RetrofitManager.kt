package com.kotlin.mvp.https

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 11:28
 * @说明:
 */

class RetrofitManager private constructor(){

    lateinit var retrofit: Retrofit

    companion object{
        val instance:RetrofitManager by lazy( mode = LazyThreadSafetyMode.SYNCHRONIZED ) {
            RetrofitManager()
        }
    }


    fun init(baseUrl:String){

        /**
         * 实现连接方式
         */

        //设置日志等级
        val httpLoggingInterceptor : HttpLoggingInterceptor=HttpLoggingInterceptor();
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY

        val okHttpClient: OkHttpClient =OkHttpClient.Builder()
        .readTimeout(60,TimeUnit.SECONDS)
        .writeTimeout(60,TimeUnit.SECONDS)
        .connectTimeout(60,TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()

        /**
         * Retrofit
         */
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    fun <T> createService(tClass: Class<T>):T{
        return retrofit.create(tClass)
    }
}


