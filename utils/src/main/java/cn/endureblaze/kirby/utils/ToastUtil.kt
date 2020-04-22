package cn.endureblaze.kirby.utils

import android.widget.Toast

/**
 * Toast 的简单封装
 */
object ToastUtil {
    /**
     * 传入字符串然后输出
     */
    fun show(charSequence: CharSequence,duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(ActManager.currentActivity,charSequence,duration).show()

    /**
     * 传入 String ID 然后输出
     */
    fun show(stringID:Int,duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(ActManager.currentActivity,
        ActManager.currentActivity?.getString(stringID),duration).show()
}