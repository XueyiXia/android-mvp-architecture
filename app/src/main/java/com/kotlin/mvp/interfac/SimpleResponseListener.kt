package com.framework.interfac;

import com.framework.exception.ApiServerException;
import com.framework.exception.CodeException;
import com.framework.log.Logs;

/**
 * @author: xiaxueyi
 * @date: 2021-10-23
 * @time: 09:15
 * @说明: 服务器数据回调,
 */

public abstract class SimpleResponseListener <T> implements ResponseListener<T> {

    @Override
    public void onSucceed(T data, String method) {
        Logs.logPint("onSucceed");
    }

    @Override
    public void onCompleted() {
        Logs.logPint("onCompleted");
    }

    @Override
    public void onError(ApiServerException exception) {
        CodeException code = exception.getCode();
        Logs.logPint("onError-->>:"+code);
    }
}
