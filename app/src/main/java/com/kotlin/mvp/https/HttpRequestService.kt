package com.fs.wawh.https;

import com.framework.https.RetrofitClient;

/**
 * @author: xiaxueyi
 * @date: 2017-11-29
 * @time: 16:51
 * @说明: Http请求服务
 */

public class HttpRequestService {

    public HttpRequestService() {}

    private static ApiService mInstance;  //公共网络请求接口对象

    /**
     * 获取接口对象
     * @return
     */
    public static ApiService getInstance(){
        if(mInstance==null){
            mInstance= EncryptRetrofitClient.getInstance().create(ApiService.class);
        }
        return mInstance;
    }
}
