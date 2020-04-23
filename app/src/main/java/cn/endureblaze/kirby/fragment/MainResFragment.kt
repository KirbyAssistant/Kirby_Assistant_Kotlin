package cn.endureblaze.kirby.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.adapter.ResPagerAdapter
import cn.endureblaze.kirby.base.BaseFragment
import com.google.android.material.tabs.TabLayout

class MainResFragment : BaseFragment() {

    /**
     * mainResPagerTitleList 页面标题列表
     * mainResPagerViewList 页面 View 列表
     */
    private lateinit var mainResPagerTitleList: MutableList<String>
    private lateinit var mainResPagerViewList: MutableList<View>


    override fun getFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_res_fragment, container, false)
    }

    override fun initView(view: View) {
        val resPagerAdapter = ResPagerAdapter(mainResPagerTitleList,mainResPagerViewList)

        val mViewPager: ViewPager = view.findViewById(R.id.main_res_viewpager)
        val mTabLayout: TabLayout = view.findViewById(R.id.main_res_tablayout)
        val inflater = LayoutInflater.from(activity)

        //创建页卡视图对象
        val consolePager = inflater.inflate(R.layout.viewpager_console, null, false)
        val emulatorPager = inflater.inflate(R.layout.viewpager_emulator, null, false)
        val cheatCodePager = inflater.inflate(R.layout.viewpager_cheatcode, null, false)

        //把页卡加入列表
        mainResPagerViewList.add(consolePager)
        mainResPagerViewList.add(emulatorPager)
        mainResPagerViewList.add(cheatCodePager)

        //添加对应的标题
        activity?.resources?.getString(R.string.tab_game)?.let { mainResPagerTitleList.add(it) }
        activity?.resources?.getString(R.string.tab_emulator)?.let { mainResPagerTitleList.add(it) }
        activity?.resources?.getString(R.string.tab_cheatcode)?.let { mainResPagerTitleList.add(it) }


        //从页卡视图中拿出列表
        val rlvConsole: RecyclerView = consolePager.findViewById(R.id.console_list)
        val rlvEmulator: RecyclerView = emulatorPager.findViewById(R.id.emulator_list)
        val rlvCheatCode: RecyclerView = cheatCodePager.findViewById(R.id.cheatcode_list)

        mTabLayout.tabMode = TabLayout.MODE_FIXED
        mTabLayout.addTab(mTabLayout.newTab().setText(mainResPagerTitleList[0]))

        mViewPager.adapter = resPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun loadDate() {

    }
}