package com.framework.mvp.mode

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.framework.mvp.interfac.IModel
import io.reactivex.disposables.Disposable

abstract class BaseModel : IModel, LifecycleObserver {

    override fun addDisposable(disposable: Disposable) {



    }


    override fun onDetach() {
        disposable()
    }

    /**
     * 清除订阅关系
     */
    private fun disposable() {}
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(lifecycleOwner: LifecycleOwner?) {
        lifecycleOwner?.lifecycle?.removeObserver(this)
    }
}