package com.framework.mvp.mode

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.framework.mvp.interfac.IModel
import io.reactivex.disposables.Disposable

abstract class BaseModel : IModel, DefaultLifecycleObserver {

    companion object{
        var TAG:String="BaseModel"
    }
    
    override fun addDisposable(disposable: Disposable) {

    }


    override fun onDetach() {
        disposable()
    }

    /**
     * 清除订阅关系
     */
    private fun disposable() {}


    override fun onCreate(owner: LifecycleOwner) {
        Log.e(TAG, "LifecycleObserver-> onCreate${owner}")
        super.onCreate(owner)
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.e(TAG, "LifecycleObserver-> onStart :${owner}")
        super.onStart(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.e(TAG, "LifecycleObserver-> onResume :${owner}")
        super.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.e(TAG, "LifecycleObserver->onPause :${owner}")
        super.onPause(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.e(TAG, "LifecycleObserver-> onStop :${owner}")
        super.onStop(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.e(TAG, "LifecycleObserver--> onDestroy :${owner.lifecycle}")
        super.onDestroy(owner)
        owner.lifecycle.removeObserver(this)
    }
}