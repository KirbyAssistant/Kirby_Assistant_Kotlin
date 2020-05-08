package cn.endureblaze.kirby.utils

import android.content.Context
import android.os.Build
import android.os.LocaleList
import android.sax.EndElementListener
import androidx.core.content.edit
import java.util.*

object LanguageUtil {

    /**
     * 设置语言的值
     * @param context 上下文
     * @param lan 需要设置的语言
     */
    fun setLanguage(context: Context, lan: String) {
        context.getSharedPreferences("settings", 0).edit {
            putString("language", lan)
            this.commit()
        }
    }

    /**
     * 获取应用于选择语言对话框的 checkedItem
     */
    fun getCheckedItem(context: Context): Int =
        when (context.getSharedPreferences("settings", 0).getString("language", "cn")) {
            "auto" -> 0
            "zh-rCN" -> 1
            "zh-rTW" -> 2
            "en" -> 3
            else -> 0
        }

    /**
     * 获取当前系统语言,注意使用 - 隔开语言和国家
     */
    fun getSysLanguage(): String {
        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList.getDefault()[0]
        } else {
            Locale.getDefault()
        }
        return "${locale.language}-${locale.country}"
    }

    /**
     * 获取当前设置的 Locale
     */
    fun getLocale(context: Context): Locale =
        when (context.getSharedPreferences("settings", 0).getString("language", "cn")) {
            "auto" -> getSysLocale()
            "zh-rCN" -> Locale("zh", "CN")
            "zh-rTW" -> Locale("zh", "TW")
            "en" -> Locale("en")
            else -> getSysLocale()
        }

    /**
     * 获取当前系统的 Locale
     */
    private fun getSysLocale(): Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        LocaleList.getDefault()[0]
    } else {
        Locale.getDefault()
    }
}