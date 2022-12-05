package com.kotlin.mvp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.framework.mvp.base.BaseActivity
import com.kotlin.mvp.https.HttpRequestService
import com.kotlin.mvp.mvp_contract.TestContract
import com.kotlin.mvp.mvp_presenter.TestPresenter

class MainActivity : BaseActivity<TestPresenter>(),TestContract.View {


    private lateinit var mTitle: TextView


    override fun createPresenter(): TestPresenter {
        return TestPresenter()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mTitle=findViewById(R.id.title)
        mTitle.text="initView"


    }

    override fun onSuccess(`object`: Any?) {
        println(`object`)
    }

    override fun onLError(`object`: Any?) {
        println(`object`)
    }
}