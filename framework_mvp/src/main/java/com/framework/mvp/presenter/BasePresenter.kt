package com.framework.mvp.presenter


import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.interfac.IView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BasePresenter<V : IView, M : IModel?> : IPresenter<V>, LifecycleObserver {
    private var mWeakReference: WeakReference<V>? = null //弱引用

    private var mView: V? = null

    protected var mModel: M? = null

    private var mCompositeDisposable: CompositeDisposable? = null

    /**
     * 创建model
     * @return
     */
    abstract fun createModel(): M

    /**
     * 绑定view
     * @param view
     */
    override fun attachView(view: V) {
        mModel = createModel()
        //添加生命周期的监听
        if (mView is LifecycleOwner) {
            val lifecycleOwner: LifecycleOwner? = mView as LifecycleOwner?
            lifecycleOwner?.lifecycle?.addObserver(this)
        }
        mWeakReference = WeakReference(view)
        mView = mWeakReference!!.get()
    }

    /**
     * 解绑view
     */
    override fun detachView() {
        if (null != mView) {
            if (mView is LifecycleOwner) {
                val lifecycleOwner: LifecycleOwner = mView as LifecycleOwner
                onDestroy(lifecycleOwner)
            }
            mView = null
        }
        if (null != mModel) {
            mModel!!.onDetach()
            mModel = null
        }
        disposable()
        if (mWeakReference != null) {
            mWeakReference!!.clear()
            mWeakReference = null
        }
    }

    /**
     * 增加订阅
     * @param disposable
     */
    fun addDisposable(disposable: Disposable) {
        if (null == mCompositeDisposable) {
            mCompositeDisposable = CompositeDisposable()
        }
        Log.e("CompositeDisposable", disposable.toString())
        mCompositeDisposable!!.add(disposable)
    }

    /**
     * 清除订阅关系
     */
    private fun disposable() {
        if (null != mCompositeDisposable) {
            Log.e("CompositeDisposable", mCompositeDisposable.toString())
            mCompositeDisposable!!.clear()
            mCompositeDisposable = null
        }
    }

    /**
     * 判断view是否绑定
     * @return
     */
    override val isViewAttached: Boolean
        get() = mWeakReference != null && mWeakReference!!.get() != null

    /**
     * 销毁订阅关系，防止内存泄漏
     * @param lifecycleOwner
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(lifecycleOwner: LifecycleOwner?) {
        lifecycleOwner?.lifecycle?.removeObserver(this)
    }
}