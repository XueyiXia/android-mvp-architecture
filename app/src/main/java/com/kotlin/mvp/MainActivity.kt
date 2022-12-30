package com.kotlin.mvp


import android.Manifest
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.framework.mvp.base.BaseActivity
import com.framework.mvp.presenter.EmptyPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions


class MainActivity : BaseActivity<EmptyPresenter>(){

    companion object{
        private const val TAG = "MainActivity"

        const val TAG_HOME = "TAG_HOME" //首页


        const val TAG_MALLS = "TAG_MALLS" //商城


        const val TAG_ME = "TAG_ME" //个人中心
    }


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


        checkPermission()
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
            TAG_ME -> {

            }
        }
        fragmentTransaction.commitAllowingStateLoss()
    }


    private fun initBottomNavigation(){
        mAHBottomNavigation.setOnItemSelectedListener(object :OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_search -> commitFragment(TAG_HOME)
                    R.id.action_settings -> commitFragment(TAG_MALLS)
                    R.id.action_navigation -> commitFragment(TAG_ME)
                }

                return true
            }
        }) 
    }


    private fun checkPermission(){
        val perms = arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        EasyPermissions.requestPermissions(this, "应用需要以下权限，请允许", 0, *perms)
    }

}