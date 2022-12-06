package com.framework.mvp.presenter


import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.interfac.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView, M : IModel> : IPresenter<V>, LifecycleObserver {

    private lateinit var mWeakReference: WeakReference<V> //弱引用

    private lateinit var mView: V

    lateinit var mModel : M

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

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
        this.mView=view
        mModel = createModel()
        //添加生命周期的监听
        if (mView is LifecycleOwner) {
            val lifecycleOwner: LifecycleOwner = mView as LifecycleOwner
            lifecycleOwner.lifecycle.addObserver(this)
        }
        mWeakReference = WeakReference(view)
        mView = mWeakReference.get()!!
    }

    /**
     * 解绑view
     */
    override fun detachView() {
        if (mView is LifecycleOwner) {
            val lifecycleOwner: LifecycleOwner = mView as LifecycleOwner
            onDestroy(lifecycleOwner)
        }
        mModel.onDetach()
        disposable()
        mWeakReference.clear()
    }

    /**
     * 增加订阅
     * @param disposable
     */
    fun addDisposable(disposable: Disposable) {
        Log.e("CompositeDisposable", disposable.toString())
        mCompositeDisposable.add(disposable)
    }

    /**
     * 清除订阅关系
     */
    private fun disposable() {
        Log.e("CompositeDisposable", mCompositeDisposable.toString())
        mCompositeDisposable.clear()
    }

    /**
     * 判断view是否绑定
     * @return
     */
    override val isViewAttached: Boolean
        get() = mWeakReference.get() != null

    /**
     * 销毁订阅关系，防止内存泄漏
     * @param lifecycleOwner
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(lifecycleOwner: LifecycleOwner?) {
        lifecycleOwner?.lifecycle?.removeObserver(this)
    }
}