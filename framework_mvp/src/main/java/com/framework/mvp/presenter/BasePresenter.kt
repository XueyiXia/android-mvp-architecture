package com.framework.mvp.presenter


import android.util.Log
import androidx.lifecycle.*
import com.framework.mvp.interfac.BaseView
import com.framework.mvp.interfac.IModel
import com.framework.mvp.interfac.IPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView, M : IModel> : IPresenter<V>, DefaultLifecycleObserver {

    companion object{
        var TAG:String="BasePresenter"
    }

    private lateinit var mWeakReference: WeakReference<V> //弱引用

    lateinit var mView: V

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
        mModel.onDetach()
        disposable()
        mWeakReference.clear()
    }

    /**
     * 增加订阅
     * @param disposable
     */
    fun addDisposable(disposable: Disposable) {
        Log.e(TAG,"addDisposable --> ${disposable.toString()}" )
        mCompositeDisposable.add(disposable)
    }

    /**
     * 清除订阅关系
     */
    private fun disposable() {
        Log.e(TAG,"disposable --> ${mCompositeDisposable.toString()}" )
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
//    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//    fun onDestroy(lifecycleOwner: LifecycleOwner?) {
//        lifecycleOwner?.lifecycle?.removeObserver(this)
//
//        disposable()
//    }

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