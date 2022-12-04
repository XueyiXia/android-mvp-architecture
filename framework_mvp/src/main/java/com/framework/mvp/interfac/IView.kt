package com.framework.mvp.interfac

import android.content.Context

/**
 * 用于规范view接口
 */
interface IView {
    /**
     * 上下文
     *
     * @return context
     */
    val context: Context?
}