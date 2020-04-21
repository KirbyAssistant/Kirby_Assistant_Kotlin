package cn.endureblaze.kirby.utils

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import java.util.*

object ActManager {
    private var activityStack: Stack<Activity>? = null

    /**
     * 单例模式 创建单一实例
     */
    fun getAppManager(): ActManager = this

    /**
     * 初始化 Stack<Activity>
     */
    private fun initActivityStack() {
        activityStack = Stack()
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        initActivityStack()
        activityStack?.add(activity)
    }

    /**
     * 获取当前 Activity（堆栈中最后一个压入的）
     */
    val currentActivity: Activity?
        get() = activityStack?.lastElement()

    /**
     * 获取当前 FragmentActivity（堆栈中最后一个压入的）
     */
    val currentFragmentActivity: FragmentActivity?
        get() = activityStack?.lastElement() as FragmentActivity?

    /**
     * 结束指定类名的 Activity
     */
    fun finishActivity(cls: Activity? = activityStack?.lastElement()) {
        val activityList: MutableList<Activity> = ArrayList()
        for (activity in this.activityStack!!) {
            if (activity.javaClass == cls) {
                activityList.add(activity)
            }
        }
        activityList.let { activityStack?.removeAll(it) }
        for (activity in activityList) {
            activity.finish()
        }
    }

    /**
     * 结束所有 Activity
     */
    private fun finishAllActivity() {
        for (activity in activityStack!!) {
            if (!activity?.isFinishing!!) {
                activity.finish()
            }
        }
    }

    /**
     * 退出程序
     */
    fun appExit() = finishAllActivity()
}