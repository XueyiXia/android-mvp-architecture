package com.kotlin.mvp

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.framework.mvp.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.kotlin.mvp.mvp_presenter.HomePresenter

class MainActivity : BaseActivity<HomePresenter>(){

    private val TAG = "FrameActivity"

    val TAG_HOME = "TAG_HOME" //首页


    val TAG_MALLS = "TAG_MALLS" //商城


    val TAG_ADDRESS_BOOK = "TAG_ADDRESS_BOOK" //通讯录


    val TAG_ME = "TAG_ME" //个人中心

    private var tag: String = TAG_HOME //标识点击了那个Fragment,默认的是定位到首页

    private var mHomeFragment: HomeFragment?=null

    private lateinit var mAHBottomNavigation: BottomNavigationView


    override fun createPresenter(): HomePresenter {
        return HomePresenter()
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

//                //商城隐藏
//                if (mMallsFragment != null && mMallsFragment.isAdded()) {
//                    fragmentTransaction.hide(mMallsFragment)
//                }
//
//                //通讯录隐藏
//                if (mAddressBookFragment != null && mAddressBookFragment.isAdded()) {
//                    fragmentTransaction.hide(mAddressBookFragment)
//                }
//
//                //个人中心隐藏
//                if (mUserFragment != null && mUserFragment.isAdded()) {
//                    fragmentTransaction.hide(mUserFragment)
//                }
            }
            TAG_MALLS -> {
//                if (mMallsFragment == null) {
//                    mMallsFragment = MyShopFragment()
//                    mMallsFragment.setArguments(intent.extras)
//                    fragmentTransaction.add(R.id.container, mMallsFragment)
//                }
//                fragmentTransaction.show(mMallsFragment)
//
//                //首页隐藏
//                if (mHomeFragment != null && mHomeFragment.isAdded()) {
//                    fragmentTransaction.hide(mHomeFragment)
//                }
//
//                //通讯录隐藏
//                if (mAddressBookFragment != null && mAddressBookFragment.isAdded()) {
//                    fragmentTransaction.hide(mAddressBookFragment)
//                }
//
//                //个人中心隐藏
//                if (mUserFragment != null && mUserFragment.isAdded()) {
//                    fragmentTransaction.hide(mUserFragment)
//                }
            }
            TAG_ADDRESS_BOOK -> {
//                if (mAddressBookFragment == null) {
//                    mAddressBookFragment = AddressBookFragment()
//                    mAddressBookFragment.setArguments(intent.extras)
//                    fragmentTransaction.add(R.id.container, mAddressBookFragment)
//                }
//                fragmentTransaction.show(mAddressBookFragment)
//
//                //首页隐藏
//                if (mHomeFragment != null && mHomeFragment.isAdded()) {
//                    fragmentTransaction.hide(mHomeFragment)
//                }
//
//                //商城隐藏
//                if (mMallsFragment != null && mMallsFragment.isAdded()) {
//                    fragmentTransaction.hide(mMallsFragment)
//                }
//
//
//                //个人中心隐藏
//                if (mUserFragment != null && mUserFragment.isAdded()) {
//                    fragmentTransaction.hide(mUserFragment)
//                }
            }
            TAG_ME -> {
//                if (mUserFragment == null) {
//                    mUserFragment = UserFragment()
//                    mUserFragment.setArguments(intent.extras)
//                    fragmentTransaction.add(R.id.container, mUserFragment)
//                }
//                fragmentTransaction.show(mUserFragment)
//
//                //首页隐藏
//                if (mHomeFragment != null && mHomeFragment.isAdded()) {
//                    fragmentTransaction.hide(mHomeFragment)
//                }
//
//                //商城隐藏
//                if (mMallsFragment != null && mMallsFragment.isAdded()) {
//                    fragmentTransaction.hide(mMallsFragment)
//                }
//
//                //商城通讯录
//                if (mAddressBookFragment != null && mAddressBookFragment.isAdded()) {
//                    fragmentTransaction.hide(mAddressBookFragment)
//                }
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