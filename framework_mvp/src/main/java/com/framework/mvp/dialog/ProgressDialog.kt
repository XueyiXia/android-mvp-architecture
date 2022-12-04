package com.framework.mvp.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import com.framework.mvp.R

/**
 * @author: xiaxueyi
 * @date: 2021-10-23
 * @time: 18:18
 * @说明: 网络请求时是的加载库
 */
class ProgressDialog(context: Context?) : Dialog(context!!, R.style.LoadingDialogStyle) {
    private var mContentView: View? = null

    init {
        mContentView = LayoutInflater.from(context).inflate(R.layout.loading_view, null)
        this.setContentView(mContentView!!)
        //旋转动画
        startAnimation()
        // 设置居中
        val params: WindowManager.LayoutParams = window!!.attributes
        params.gravity = Gravity.CENTER
        // 设置背景层透明度
        params.dimAmount = 0.35f
        window!!.attributes = params
    }

    override fun show() {
        super.show()
        startAnimation()
    }

    /**
     * 开始动画
     */
    private fun startAnimation() {
//        ImageView loadingLogo = (ImageView) mContentView.findViewById(R.id.loading_logo);
        val progressBar: ProgressBar = mContentView!!.findViewById<View>(R.id.progressbar) as ProgressBar
        //Animation rotate = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
//        progressBar.startAnimation(rotate);
    }
}