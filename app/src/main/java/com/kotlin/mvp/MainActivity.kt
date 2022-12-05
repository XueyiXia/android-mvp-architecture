package com.kotlin.mvp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.framework.mvp.base.BaseActivity
import com.kotlin.mvp.mvp_contract.HomeContract
import com.kotlin.mvp.mvp_presenter.HomePresenter

class MainActivity : BaseActivity<HomePresenter>(),HomeContract.View {


    private lateinit var mTitle: TextView


    override fun createPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mTitle=findViewById(R.id.title)
        mTitle.text="initView"


        mPresenter.requestHome(1)


    }

    override fun onSuccess(`object`: Any?) {
        println(`object`)
    }

    override fun onLError(`object`: Any?) {
        println(`object`)
    }
}