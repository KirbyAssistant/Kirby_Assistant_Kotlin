package cn.endureblaze.kirby.utils

import android.widget.Toast

/**
 * Toast 的简单封装
 */
object ToastUtil {
    /**
     * 传入字符串然后输出
     * @param charSequence 需要输出的字符串
     * @param duration 时长，默认为 Toast.LENGTH_SHORT
     */
    fun show(charSequence: CharSequence,duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(ActManager.currentActivity,charSequence,duration).show()

    /**
     * 传入 String ID 然后输出
     * @param stringID 需要输出的 String 的 ID
     * @param duration 时长，默认为 Toast.LENGTH_SHORT
     */
    fun show(stringID:Int,duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(ActManager.currentActivity, ActManager.currentActivity.getString(stringID),duration).show()
}