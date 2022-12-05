package com.google.mvp.https;

import com.framework.exception.ApiServerException;
import com.framework.exception.CodeException;
import com.framework.schedulers.RetryWhenNetwork;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * @author: xiaxueyi
 * @date: 2017-12-01
 * @time: 13:52
 * @说明: 订阅者转换器
 */

public class ConvertSchedulers<T> implements ObservableTransformer<Response<T>,T> {

    private static final String TAG="ConvertSchedulers";

    public ConvertSchedulers() {

    }

    @Override
    public ObservableSource<T> apply(@NonNull Observable<Response<T>> upstream) {

        return upstream
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap( (Function<Response<T>, ObservableSource<T>>) tResponse -> {
                    if(tResponse.isSuccessful()) {

                        return Observable.just(tResponse.body());
                    }
                    return Observable.error(new ApiServerException(CodeException.DiyException,tResponse.code(),tResponse.body().toString()));
                } )
                .observeOn(AndroidSchedulers.mainThread(), true)
                .retryWhen(new RetryWhenNetwork());


    }
}
