package cn.endureblaze.kirby.utils

import android.os.Build

object PhoneUtil  {
    val brand: String
        get() = Build.BRAND

    val model: String
        get() = Build.MODEL

    val product: String
        get() = Build.PRODUCT

    val androidVersion: String
        get() = Build.VERSION.RELEASE
}