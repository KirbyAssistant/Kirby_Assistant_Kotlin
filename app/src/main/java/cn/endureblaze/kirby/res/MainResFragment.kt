package cn.endureblaze.kirby.res

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.adapter.ResPagerAdapter
import cn.endureblaze.kirby.base.BaseFragment
import cn.endureblaze.kirby.databinding.MainResFragmentBinding
import cn.endureblaze.kirby.databinding.ViewpagerCheatcodeBinding
import cn.endureblaze.kirby.databinding.ViewpagerConsoleBinding
import cn.endureblaze.kirby.databinding.ViewpagerEmulatorBinding
import cn.endureblaze.kirby.res.adapter.ConsoleAdapter
import cn.endureblaze.kirby.res.dataclass.Console
import cn.endureblaze.kirby.res.dataclass.Emulator
import com.google.android.material.tabs.TabLayout

class MainResFragment : BaseFragment<MainResFragmentBinding>(R.layout.main_res_fragment) {

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

    override fun initBinding(view: View): MainResFragmentBinding {
        return MainResFragmentBinding.bind(view)
    }

    override fun initView() {
        val resPagerAdapter = ResPagerAdapter(mainResPagerTitleList, mainResPagerViewList)

        val mViewPager = binding.mainResViewpager
        val mTabLayout = binding.mainResTablayout
        val inflater = LayoutInflater.from(activity)

        //创建页卡视图对象
        val consolePagerBinding = ViewpagerConsoleBinding.inflate(inflater)
        val emulatorPagerBinding = ViewpagerEmulatorBinding.inflate(inflater)
        val cheatCodePagerBinding = ViewpagerCheatcodeBinding.inflate(inflater)

        //把页卡加入列表
        mainResPagerViewList.add(consolePagerBinding.root)
        mainResPagerViewList.add(emulatorPagerBinding.root)
        mainResPagerViewList.add(cheatCodePagerBinding.root)

        //添加对应的标题
        activity?.resources?.getString(R.string.tab_game)?.let { mainResPagerTitleList.add(it) }
        activity?.resources?.getString(R.string.tab_emulator)?.let { mainResPagerTitleList.add(it) }
        activity?.resources?.getString(R.string.tab_cheatcode)?.let { mainResPagerTitleList.add(it) }


        //从页卡视图中拿出列表
        rlvConsole = consolePagerBinding.consoleList
        rlvEmulator = emulatorPagerBinding.emulatorList
        rlvCheatCode = cheatCodePagerBinding.cheatcodeList

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