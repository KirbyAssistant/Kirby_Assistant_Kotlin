package cn.endureblaze.kirby.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

lateinit var context_in: Context
val packageManager: PackageManager = context_in.packageManager
val packageInfo: PackageInfo = packageManager.getPackageInfo(context_in.packageName, 0)
val labelRes: Int = packageInfo.applicationInfo.labelRes

class AppUtil {
    /**
     * 获取应用程序名称
     */
    fun getAppName(context: Context): String {
        context_in = context
        return context.resources.getString(labelRes)
    }

    /**
     * 获取程序版本信息
     */
    fun getVersionCode(context: Context): Int {
        context_in = context
        return packageInfo.versionCode
    }
}