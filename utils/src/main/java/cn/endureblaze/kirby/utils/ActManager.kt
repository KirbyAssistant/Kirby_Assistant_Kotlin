package cn.endureblaze.kirby.utils

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import java.util.*

/**
 * 用栈来管理所有的 Activity
 */
object ActManager {
    private var activityStack: Stack<Activity> = Stack()

    /**
     * 添加Activity到堆栈
     * @param activity 添加进栈里的 Activity
     */
    fun addActivity(activity: Activity) = activityStack.add(activity)

    /**
     * 获取当前 Activity（堆栈中最后一个压入的）
     */
    val currentActivity: Activity
        get() = activityStack.lastElement()

    /**
     * 获取当前 FragmentActivity（堆栈中最后一个压入的）
     */
    val currentFragmentActivity: FragmentActivity?
        get() = activityStack.lastElement() as FragmentActivity?

    /**
     * 结束指定类名的 Activity
     * @param cls 需要结束的 Activity 类名
     */
    fun finishActivity(cls: Activity? = activityStack.lastElement()) {
        val activityList: MutableList<Activity> = ArrayList()
        for (activity in this.activityStack) {
            if (activity.javaClass == cls) {
                activityList.add(activity)
            }
        }
        activityList.let { activityStack.removeAll(it) }
        for (activity in activityList) {
            activity.finish()
        }
    }

    /**
     * 结束所有 Activity
     */
    private fun finishAllActivity() {
        for (activity in activityStack) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

    /**
     * 退出程序
     */
    fun appExit() = finishAllActivity()
}