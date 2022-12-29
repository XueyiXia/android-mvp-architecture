package com.framework.mvp.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.framework.mvp.interfac.BaseView
import com.framework.mvp.interfac.IPresenter
import com.framework.mvp.utils.HelperUtils
import io.reactivex.annotations.NonNull
import pub.devrel.easypermissions.EasyPermissions

/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 10:13
 * @说明:
 */
 abstract class BaseActivity <P : IPresenter<*>> :AppCompatActivity() , BaseView , EasyPermissions.PermissionCallbacks{

    lateinit var mPresenter: P


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter.attachView(this)
        setContentView(getLayoutResId())
        initView(window.decorView, savedInstanceState)
    }


    /**
     * 重写要申请权限的Activity或者Fragment的onRequestPermissionsResult()方法，
     * 在里面调用EasyPermissions.onRequestPermissionsResult()，实现回调。
     *
     * @param requestCode  权限请求的识别码
     * @param permissions  申请的权限
     * @param grantResults 授权结果
     */
    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Log.i("EasyPermissions", "获取成功的权限$perms")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {

        HelperUtils.showPermissionsDenied(this,perms)
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