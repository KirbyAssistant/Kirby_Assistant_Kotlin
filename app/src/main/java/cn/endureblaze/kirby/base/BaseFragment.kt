package cn.endureblaze.kirby.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private var isViewOK = false //是否完成 View 初始化
    private var isFirst = true //是否为第一次加载

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = getFragmentLayout(inflater, container, savedInstanceState)
        initView(view)
        // 完成 initView 后改变view的初始化状态为完成
        isViewOK = true
        return view
    }

    /**
     * 获取 fragment 的布局
     */
    abstract fun getFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

    /**
     * fragment 初始化 view 的方法
     */
    abstract fun initView(view: View)

    override fun onResume() {
        super.onResume()
        //在 onResume 进行数据懒加载
        initLoadData()
    }

    private fun initLoadData() {
        if (isViewOK && isFirst) {
            //加载数据时判断是否完成view的初始化，以及是不是第一次加载此数据
            loadDate()
            //加载第一次数据后改变状态，后续不再重复加载
            isFirst = false
        }
    }

    /**
     * fragment 实现懒加载的方法，即在这里加载数据
     */
    abstract fun loadDate()
}