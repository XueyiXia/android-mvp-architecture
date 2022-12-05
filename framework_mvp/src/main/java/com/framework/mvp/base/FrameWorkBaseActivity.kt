package com.framework.mvp.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.framework.mvp.R
import com.framework.mvp.dialog.ProgressDialog
import com.framework.mvp.interfac.BaseInterface
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.interfac.IView
import com.framework.mvp.interfac.ProgressDialogListener
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.reflect.ParameterizedType
import kotlin.system.exitProcess

abstract class FrameWorkBaseActivity <P:IPresenter<*>,T:ViewBinding>  : AppCompatActivity(), IView, ProgressDialogListener, BaseInterface {

    private var mProgressDialogList: SparseArray<ProgressDialog>? = SparseArray<ProgressDialog>() //存储进度条列表

    private var mInputMethodManager: InputMethodManager? = null //键盘管理使用的工具类

    private var lastClickTime: Long = 0 //最后点击事件

    private var exitTime: Long = 0 //退出程序的时间

    private lateinit var mPresenter: P

    private lateinit var mViewBinding: T

    protected abstract fun createPresenter(): P //创建Presenter层，全局使用

    private var mCompositeDisposable: CompositeDisposable? = null //将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //View 和model 的桥梁
        mPresenter = createPresenter()
        mPresenter?.attachView(this as Nothing)



        /**
         * 实例化ViewBinding
         */
        initViewBinding()

        /**
         * 函数入口
         */
        /**
         * 函数入口
         */
        initView(window.decorView, savedInstanceState)
    }


    private fun initViewBinding() {
        try {
            /**
             * 实现ViewBinding
             */
            val superclass = javaClass.genericSuperclass
            if (superclass != null) {
                /**
                 * getActualTypeArguments()[0]为IPresenter对象，getActualTypeArguments()[1]ViewBinding，
                 */
                val aClass = (superclass as ParameterizedType).actualTypeArguments[1] as Class<*>
                val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
                mViewBinding = method.invoke(null, layoutInflater) as T
                setContentView(mViewBinding.root)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun createProgressDialog(id: Int): Dialog? {
        var progressDialog: ProgressDialog? = mProgressDialogList?.get(id)
        try {
            if (progressDialog == null) {
                progressDialog = ProgressDialog(this)
                mProgressDialogList?.put(id, progressDialog)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return progressDialog
    }

    override fun showProgressDialog(id: Int, cancelable: Boolean) {
        try {
            var progressDialog: ProgressDialog? = mProgressDialogList?.get(id)
            if (progressDialog == null) {
                progressDialog = ProgressDialog(this)
                progressDialog.setCancelable(cancelable)
                mProgressDialogList?.put(id, progressDialog)
            }
            progressDialog.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun dismissProgressDialog(id: Int) {
        try {
            val progressDialog: ProgressDialog? = mProgressDialogList?.get(id)
            if (progressDialog != null) {
                if (progressDialog.isShowing) {
                    progressDialog.dismiss()
                    mProgressDialogList?.remove(id)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun addRequestQueue(disposable: Disposable?) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed()) {
            mCompositeDisposable = CompositeDisposable()
        }
        if (disposable != null) {
            mCompositeDisposable!!.add(disposable)
        }
//        Logs.logError("RequestQueue", "disposable-->>$disposable")
        for (i in 0 until mCompositeDisposable!!.size()) {
            Log.e("RequestQueue", "mCompositeDisposable->>$mCompositeDisposable")
        }
    }

    override fun removeRequestQueue(disposable: Disposable?) {
        Log.e("RequestQueue", "removeRequestQueue--->>$disposable")
        mCompositeDisposable?.dispose()
    }

    /**
     * 显示弹窗，先判断Activity 是否被finishing
     *
     * @param dialog
     */
    fun showDialog(dialog: Dialog?) {
        try {
            if (!isFinishing && dialog != null && !dialog.isShowing) {
                dialog.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 关闭弹窗
     *
     * @param dialog
     */
    fun dismissDialog(dialog: Dialog?) {
        try {
            if (!isFinishing && dialog != null && dialog.isShowing) {
                dialog.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 隐藏键盘
     */
    fun hideSoftKeyBoard() {
        //获取当前焦点的View
        val localFocusView: View? = currentFocus
        if (mInputMethodManager == null) {
            mInputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        }
        if (localFocusView != null && mInputMethodManager != null) {
            mInputMethodManager!!.hideSoftInputFromWindow(localFocusView.windowToken, 2)
        }
    }

    /**
     * 退出应用
     */
    fun exit() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, R.string.cancel_app,Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            finish()
            exitProcess(0)
            System.gc()
        }
    }

    /**
     * activity跳转（无参数）
     * @param className
     */
    fun startActivity(className: Class<out Activity?>?) {
        val intent = Intent(this, className)
        startActivity(intent)
    }

    /**
     * activity跳转（有参数）
     * @param className
     */
    fun startActivity(className: Class<out Activity?>?, bundle: Bundle?) {
        val intent = Intent(this, className)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * activity结果跳转（没有参数）
     * @param className
     * @param requestCode
     */
    fun startActivityForResult(className: Class<out Activity?>?, requestCode: Int) {
        val intent = Intent(this, className)
        startActivityForResult(intent, requestCode)
    }

    /**
     * activity结果跳转（有参数）
     * @param className
     * @param bundle
     * @param requestCode
     */
    fun startActivityForResult(
        className: Class<out Activity?>?,
        bundle: Bundle?,
        requestCode: Int
    ) {
        val intent = Intent(this, className)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }//记录最后一次点击时间

    /**
     * 是否需要延迟点击，true 表示延迟
     * @return
     */
    val isDelayClick: Boolean
        get() {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime > DELAY) {
                lastClickTime = currentTime //记录最后一次点击时间
                return true
            }
            return false
        }

    /**
     * 是否使用eventBus
     *
     * @return
     */
    protected abstract val isUseEventBus: Boolean

    /**
     * 入口函数
     */
    abstract fun initView(rootView: View?, savedInstanceState: Bundle?)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        try {
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        try {
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.onSaveInstanceState(outState)
    }

    override fun finish() {
        super.finish()
        /**
         * 界面结束的时候，关闭软键盘
         */
        hideSoftKeyBoard()
    }

    protected override fun onStart() {
        super.onStart()
    }

    protected override fun onResume() {
        super.onResume()
    }

    protected override fun onPause() {
        super.onPause()
    }

    protected override fun onStop() {
        super.onStop()
    }

    protected override fun onDestroy() {
        super.onDestroy()
        if (mProgressDialogList != null) {
            mProgressDialogList!!.clear()
            mProgressDialogList = null
        }
        /**
         * 销毁组件
         */
        if (mInputMethodManager != null) {
            mInputMethodManager = null
        }
        /**
         * 销毁MVP
         */
        if (null != mPresenter) {
            mPresenter?.detachView()
        }
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
            mCompositeDisposable = null
        }
    }

    companion object {
        private const val TAG = "FrameWorkBaseActivity"
        private const val DELAY = 1500 //连击事件间隔
    }
}