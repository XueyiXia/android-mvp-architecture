package com.kotlin.mvp.https

import java.io.Serializable

class BaseRes<D> : Serializable {
    var isSuccess = false
    var code = 0
    var msg: String? = null
    var data: D? = null
        private set

    fun setData(data: D) {
        this.data = data
    }

    companion object {
        const val sUCCESS = 200
    }
}