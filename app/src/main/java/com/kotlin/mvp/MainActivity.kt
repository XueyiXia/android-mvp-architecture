package com.kotlin.mvp

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.framework.mvp.base.BaseActivity
import com.framework.mvp.presenter.EmptyPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : BaseActivity<EmptyPresenter>(){

    private val TAG = "FrameActivity"

    val TAG_HOME = "TAG_HOME" //首页


    val TAG_MALLS = "TAG_MALLS" //商城


    val TAG_ADDRESS_BOOK = "TAG_ADDRESS_BOOK" //通讯录


    val TAG_ME = "TAG_ME" //个人中心

    private var tag: String = TAG_HOME //标识点击了那个Fragment,默认的是定位到首页

    private var mHomeFragment: HomeFragment?=null

    private lateinit var mAHBottomNavigation: BottomNavigationView


    override fun createPresenter(): EmptyPresenter {
        return EmptyPresenter()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mAHBottomNavigation=findViewById(R.id.bottom_navigation)


        /**
         * 切换Fragment
         */
        commitFragment(tag)


        /**
         * 实例化底部导航栏
         */
        initBottomNavigation()
    }


    /**
     * 页面切换
     * @param tag
     */
    private fun commitFragment(tag: String) {
        this.tag = tag
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (tag) {
            TAG_HOME -> {
                if(mHomeFragment==null){
                    mHomeFragment=HomeFragment()
                    fragmentTransaction.add(R.id.container, mHomeFragment!!)
                }

                mHomeFragment!!.arguments = intent.extras
                fragmentTransaction.show(mHomeFragment!!)

            }
            TAG_MALLS -> {

            }
            TAG_ADDRESS_BOOK -> {

            }
            TAG_ME -> {

            }
        }
        fragmentTransaction.commitAllowingStateLoss()
    }


    private fun initBottomNavigation(){
        mAHBottomNavigation.setOnItemSelectedListener(object :OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var position=item.itemId
                when (position) {
                    0 -> commitFragment(TAG_HOME)
                    1 -> commitFragment(TAG_MALLS)
                    2 -> commitFragment(TAG_ADDRESS_BOOK)
                    3 -> commitFragment(TAG_ME)
                }

                return true
            }
        }) 
    }

}