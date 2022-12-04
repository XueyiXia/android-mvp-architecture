package com.framework.mvp.interfac

import android.app.Dialog

/**
 * @author: xiaxueyi
 * @date: 2021-10-23
 * @time: 13:58
 * @说明: 进度条事件监听
 */
interface ProgressDialogListener {
    fun createProgressDialog(id: Int): Dialog? //创建进度条
    fun showProgressDialog(id: Int, cancelable: Boolean) //显示进度条
    fun dismissProgressDialog(id: Int) //关闭进度条
}