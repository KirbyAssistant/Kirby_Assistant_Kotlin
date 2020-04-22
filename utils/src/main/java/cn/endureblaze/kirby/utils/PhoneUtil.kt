package cn.endureblaze.kirby.utils

import android.os.Build

/**
 * 获取手机信息
 */
object PhoneUtil  {

    /**
     * 获取主板名称
     */
    val brand: String
        get() = Build.BRAND

    /**
     * 获取手机型号
     */
    val model: String
        get() = Build.MODEL

    /**
     * 获取手机产品名称
     */
    val product: String
        get() = Build.PRODUCT

    /**
     * 获取手机的安卓版本号
     */
    val androidVersion: Int
        get() = Build.VERSION.SDK_INT
}