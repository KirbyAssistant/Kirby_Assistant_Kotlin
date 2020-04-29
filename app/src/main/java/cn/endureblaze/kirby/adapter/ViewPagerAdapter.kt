package cn.endureblaze.kirby.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cn.endureblaze.kirby.base.BaseFragment

class ViewPagerAdapter constructor (
    fragmentManager: FragmentManager,
    behavior: Int,
    private val fragmentList: List<BaseFragment<*,*>>
) :
    FragmentPagerAdapter(fragmentManager, behavior) {

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount() = fragmentList.size
}