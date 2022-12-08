package com.framework.versionplugin


/**
 * @author: xiaxueyi
 * @date: 2022-09-29
 * @time: 11:21
 * @说明:  如果数量少的话，放在一个类里面就可以，如果数量多的话，可以拆分为多个类
 */
object Versions {
    const val appcompat = "1.5.0"
    const val kotlin = "1.3.72"
    const val recyclerview = "1.2.1"
    const val coreKtx = "1.9.0"
    const val constraintLayout="2.1.4"
    const val material = "1.6.1"
    const val lifecycle_viewmodel = "2.2.0"
    const val lifecycle_livedata = "2.2.0"
    const val banner = "cn.bingoogolapple:bga-banner:2.2.6@aar"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle_viewmodel}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle_livedata}"
}

object Retrofit{
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val adapter_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:2.9.0"
    const val converter_scalars = "com.squareup.retrofit2:converter-scalars:2.6.2"
}

object Rxjava3{
    const val rxjava = "io.reactivex.rxjava3:rxjava:3.0.0"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    const val gson = "com.google.code.gson:gson:2.8.9"
    const val rxLifecycle = "com.trello.rxlifecycle2:rxlifecycle-components:2.2.2"
}

object OkHttp{
    const val okhttp3 = "com.squareup.okhttp3:okhttp:4.10.0"
    const val okio = "com.squareup.okio:okio:2.8.0"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:4.9.1"
}





