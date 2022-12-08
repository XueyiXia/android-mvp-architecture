package com.framework.mvp.dialog

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.framework.mvp.R

/**
 * @author xiaxueyi
 * @date: 2022-11-23
 * @time: 17-10
 * @说明: 共同的加载框
 */
class CustomLoadingView @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(
    mContext, attrs, defStyle
) {
    private lateinit var mProgressBar: ProgressBar//进度条
    private lateinit var rlProgressBar: RelativeLayout //进度布局
    private lateinit var loading_expression: LinearLayout//异常布局
    private lateinit var loading_express_msg: TextView //异常布局提示

    /**
     * 加载框是否显示
     * @return
     */
    var isShowing = false //加载框是否显示
        private set

    /**
     * this表示当前的，不能使用super
     * @param context
     */
    init {
        initWidget()
    }

    /**
     * 初始化组件
     */
    private fun initWidget() {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.custom_loading_view, this, true)
        mProgressBar = view.findViewById<View>(R.id.progressbar) as ProgressBar
        rlProgressBar = view.findViewById<View>(R.id.rlProgressDialog) as RelativeLayout
        loading_expression = view.findViewById<View>(R.id.loading_expression) as LinearLayout
        loading_express_msg = view.findViewById<View>(R.id.loading_express_msg) as TextView
    }

    /**
     * 设置异常提示
     * @param errorText
     */
    fun setErrorText(errorText: String?, onClick: View.OnClickListener?) {
        if (rlProgressBar.visibility == View.VISIBLE) {
            rlProgressBar.visibility = View.GONE
        }
        isShowing = false
        loading_expression.visibility = View.VISIBLE
        if (onClick != null) {
            loading_expression.setOnClickListener(onClick)
        }
        loading_express_msg.text = errorText
    }

    /**
     * 加载框显示
     */
    fun show() {
        if (!isShowing) {
            mProgressBar.visibility = View.VISIBLE
            rlProgressBar.visibility = View.VISIBLE
            if (loading_expression.visibility == View.VISIBLE) {
                loading_expression.visibility = View.GONE
            }
            isShowing = true
        }
    }

    fun show(resId: Int) {
        if (!isShowing && resId != -1) {
            mProgressBar.visibility = View.VISIBLE
            rlProgressBar.visibility = View.VISIBLE
            rlProgressBar.setBackgroundResource(resId)
            if (loading_expression.visibility == View.VISIBLE) {
                loading_expression.visibility = View.GONE
            }
            isShowing = true
        }
    }

    /**
     * 关闭加载框
     */
    fun dismiss() {
        isShowing = false
        this.visibility = View.GONE
    }
}