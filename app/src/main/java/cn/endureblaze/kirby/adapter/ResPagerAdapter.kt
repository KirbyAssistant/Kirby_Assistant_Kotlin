package cn.endureblaze.kirby.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class ResPagerAdapter constructor(private val titleList: List<String>, private val viewList: List<View>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int =viewList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(viewList[position])
        return viewList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) = container.removeView(viewList[position])

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]
}