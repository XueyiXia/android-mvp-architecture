package com.framework.mvp.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.framework.mvp.interfac.BaseView
import com.framework.mvp.interfac.IPresenter

/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 10:13
 * @说明:
 */
 abstract class BaseActivity <P : IPresenter<*>> :AppCompatActivity() , BaseView {

    lateinit var mPresenter: P


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter.attachView(this)
        setContentView(getLayoutResId())
        initView(window.decorView, savedInstanceState)
    }


    /**
     * 创建Presenter层，全局使用
     * @return P
     */
    protected abstract fun createPresenter(): P

    /**
     * 资源文件
     * @return Int
     */
    abstract fun getLayoutResId(): Int //资源布局文件id;


    /**
     * 入口函数
     */
    abstract fun initView(rootView: View, savedInstanceState: Bundle?)


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}