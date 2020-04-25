package cn.endureblaze.kirby.res

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.adapter.ResPagerAdapter
import cn.endureblaze.kirby.base.BaseFragment
import cn.endureblaze.kirby.res.adapter.ConsoleAdapter
import cn.endureblaze.kirby.res.dataclass.Console
import cn.endureblaze.kirby.res.dataclass.Emulator
import com.google.android.material.tabs.TabLayout

class MainResFragment : BaseFragment() {

    /**
     * mainResPagerTitleList 页面标题列表
     * mainResPagerViewList 页面 View 列表
     */
    private var mainResPagerTitleList: MutableList<String> = ArrayList()
    private var mainResPagerViewList: MutableList<View> = ArrayList()

    private lateinit var rlvConsole: RecyclerView
    private lateinit var rlvEmulator: RecyclerView
    private lateinit var rlvCheatCode: RecyclerView

    private var consoleList: MutableList<Console> = ArrayList()
    private var emulatorList: MutableList<Emulator> = ArrayList()

    override fun getFragmentLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_res_fragment, container, false)
    }

    override fun initView(view: View) {
        val resPagerAdapter = ResPagerAdapter(mainResPagerTitleList, mainResPagerViewList)

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
        rlvConsole = consolePager.findViewById(R.id.console_list)
        rlvEmulator = emulatorPager.findViewById(R.id.emulator_list)
        rlvCheatCode = cheatCodePager.findViewById(R.id.cheatcode_list)

        mTabLayout.tabMode = TabLayout.MODE_FIXED
        mTabLayout.addTab(mTabLayout.newTab().setText(mainResPagerTitleList[0]))

        mViewPager.adapter = resPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun loadDate() {
        //主机列表配置
        ResourceData.initConsoleData(consoleList)
        val layoutManagerConsole = GridLayoutManager(activity, 1)
        val consoleAdapter = ConsoleAdapter(consoleList)

        rlvConsole.layoutManager = layoutManagerConsole
        rlvConsole.adapter = consoleAdapter

        //模拟器列表
        ResourceData.initEmulatorData(emulatorList)
        val layoutManagerEmulator = GridLayoutManager(activity, 3)
    }
}