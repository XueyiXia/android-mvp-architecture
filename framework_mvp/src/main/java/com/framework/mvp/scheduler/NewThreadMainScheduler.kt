package com.framework.mvp.scheduler

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers



/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 13:11
 * @说明:
 */

open class NewThreadMainScheduler<T>  : BaseScheduler<T>(Schedulers.newThread(), AndroidSchedulers.mainThread())
