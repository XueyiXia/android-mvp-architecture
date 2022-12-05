package com.kotlin.mvp.https

/**
 * @author: xiaxueyi
 * @date: 2021-10-25
 * @time: 14:13
 * @说明: 接口的URL
 */
interface HttpApi {
    companion object {
        //    String BASE_URL="http://192.168.02.95/";
        const val BASE_URL = "http://app.test.xywarehouse.xy/mall/" //测试环境
        const val H5_BASE_URL = "http://192.168.11.189/" //H5测试域名
        const val WEB_PREFIX = "" //正式web域名
        const val HTTP_SPLICE = ""
        const val HOME_INDEX = "index/via/getConfig"
    }
}