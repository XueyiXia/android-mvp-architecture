package com.framework.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.framework.mvp.interfac.IPresenter


/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 10:13
 * @说明:
 */
 abstract class BaseFragment<P : IPresenter<*>>: Fragment(){


    lateinit var mPresenter: P

    private lateinit var mRootView: View


    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据是否加载过了
     */
    private var hasLoadData = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(getLayoutResId(), container, false)
        return mRootView
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView(mRootView, savedInstanceState)
        lazyLoadDataIfPrepared()

    }

    private fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    /**
     * 懒加载
     */
    private fun lazyLoad() {}


    override fun onDestroy() {
        super.onDestroy()
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
}
