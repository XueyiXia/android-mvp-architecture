package com.kotlin.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.framework.mvp.base.BaseActivity
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.presenter.EmptyPresenter
import com.kotlin.mvp.mvp_presenter.HomePresenter

class SplashActivity : BaseActivity<EmptyPresenter>() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
//    }


    override fun createPresenter(): EmptyPresenter {
        return EmptyPresenter()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {

        var intent:Intent= Intent()
        intent.setClass(SplashActivity@this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}