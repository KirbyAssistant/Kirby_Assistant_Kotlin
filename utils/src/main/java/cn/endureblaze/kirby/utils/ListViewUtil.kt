package cn.endureblaze.kirby.utils

import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView


object ListViewUtil {
    fun setListViewHeightBasedOnChildren(listView: ListView) {
        //获取ListView对应的Adapter
        val listAdapter: ListAdapter = listView.adapter
            ?: // pre-condition
            return
        var totalHeight = 0
        var i = 0
        val len: Int = listAdapter.count
        while (i < len) {
            //listAdapter.getCount()返回数据项的数目
            val listItem: View = listAdapter.getView(i, null, listView)
            listItem.measure(0, 0) //计算子项View 的宽高
            totalHeight += listItem.measuredHeight //统计所有子项的总高度
            i++
        }
        val params: ViewGroup.LayoutParams = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        //listView.getDividerHeight()获取子项间分隔符占用的高度
        //params.height最后得到整个ListView完整显示需要的高度
        listView.layoutParams = params
    }
}