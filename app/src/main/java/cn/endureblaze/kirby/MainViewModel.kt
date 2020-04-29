package cn.endureblaze.kirby

import androidx.lifecycle.ViewModel
import cn.endureblaze.kirby.base.BaseFragment
import cn.endureblaze.kirby.customview.NoScrollViewPager
import cn.endureblaze.kirby.databinding.ActivityMainBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding
import java.util.*

class MainViewModel : ViewModel() {

    lateinit var binding: ActivityMainBinding

    lateinit var toolbarBinding: LayoutToolbarBinding

    var fragmentList: MutableList<BaseFragment<*,*>> = ArrayList()
    var pagerTitleList: MutableList<String> = ArrayList<String>()

    lateinit var mainFragmentViewPager: NoScrollViewPager

    var fragmentPos = 0

}