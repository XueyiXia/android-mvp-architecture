package com.kotlin.mvp.https

/**
 * @author: xiaxueyi
 * @date: 2021-10-25
 * @time: 14:13
 * @说明: 接口的URL
 */
interface HttpApi {
    companion object {
        const val BASE_URL = "http://baobab.kaiyanapp.com/api/"
        const val HOME_INDEX = "v2/feed?"
    }
}