package com.framework.interfac;

import com.framework.exception.ApiServerException;

/**
 * @author: xiaxueyi
 * @date: 2017-11-30
 * @time: 09:16
 * @说明: 服务器数据返回监听
 */

public interface ResponseListener<T> {

    void onSucceed(T data,String method);   //成功的时候回调

    void onCompleted(); //完成的时候回调,不管成功与否，观察者都结束

    void onError(ApiServerException exception);     //发生错误的时候回调

}
