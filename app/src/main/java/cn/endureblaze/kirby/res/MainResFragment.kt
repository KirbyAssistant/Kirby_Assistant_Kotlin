package cn.endureblaze.kirby.res

import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.adapter.ResPagerAdapter
import cn.endureblaze.kirby.base.BaseFragment
import cn.endureblaze.kirby.databinding.MainResFragmentBinding
import cn.endureblaze.kirby.databinding.ViewpagerCheatcodeBinding
import cn.endureblaze.kirby.databinding.ViewpagerConsoleBinding
import cn.endureblaze.kirby.databinding.ViewpagerEmulatorBinding
import cn.endureblaze.kirby.res.adapter.CheatcodeGameAdapter
import cn.endureblaze.kirby.res.adapter.ConsoleAdapter
import cn.endureblaze.kirby.res.adapter.EmulatorAdapter
import cn.endureblaze.kirby.res.viewmodel.ResViewModel
import cn.endureblaze.kirby.utils.ActManager
import com.google.android.material.tabs.TabLayout

class MainResFragment : BaseFragment<MainResFragmentBinding, ResViewModel>(R.layout.main_res_fragment) {

    private lateinit var rlvConsole: RecyclerView
    private lateinit var rlvEmulator: RecyclerView
    private lateinit var rlvCheatcode: RecyclerView

    override fun initBinding(view: View): MainResFragmentBinding = MainResFragmentBinding.bind(view)

    override fun initViewModel(): ResViewModel = ViewModelProvider(this)[ResViewModel::class.java]

    override fun initView() {
        val mViewPager = binding.mainResViewpager
        val mTabLayout = binding.mainResTablayout
        val inflater = LayoutInflater.from(activity)

        val consolePagerBinding = ViewpagerConsoleBinding.inflate(inflater)
        val emulatorPagerBinding = ViewpagerEmulatorBinding.inflate(inflater)
        val cheatCodePagerBinding = ViewpagerCheatcodeBinding.inflate(inflater)

        val mainResPagerTitleList: List<String> = listOf(
            ActManager.currentActivity.resources.getString(R.string.tab_game),
            ActManager.currentActivity.resources.getString(R.string.tab_emulator),
            ActManager.currentActivity.resources.getString(R.string.tab_emulator)
        )
        val mainResPagerViewList: List<View> = listOf(
            consolePagerBinding.root,
            emulatorPagerBinding.root,
            cheatCodePagerBinding.root
        )

        val resPagerAdapter = ResPagerAdapter(mainResPagerTitleList, mainResPagerViewList)

        //从页卡视图中拿出列表
        rlvConsole = consolePagerBinding.consoleList
        rlvEmulator = emulatorPagerBinding.emulatorList
        rlvCheatcode = cheatCodePagerBinding.cheatcodeList

        mTabLayout.tabMode = TabLayout.MODE_FIXED
        mTabLayout.addTab(mTabLayout.newTab().setText(mainResPagerTitleList[0]))

        mViewPager.adapter = resPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun loadDate() {
        //主机列表配置
        val layoutManagerConsole = GridLayoutManager(activity, 1)
        val consoleAdapter = ConsoleAdapter(viewModel.consoleList)

        rlvConsole.layoutManager = layoutManagerConsole
        rlvConsole.adapter = consoleAdapter

        //模拟器列表
        val layoutManagerEmulator = GridLayoutManager(activity, 3)
        val emulatorAdapter = EmulatorAdapter(viewModel.emulatorList)

        rlvEmulator.layoutManager = layoutManagerEmulator
        rlvEmulator.adapter = emulatorAdapter

        //金手指游戏列表
        val layoutManagerCheatcodeGame = GridLayoutManager(activity,1)
        val cheatCodeGameAdapter = CheatcodeGameAdapter(viewModel.cheatcodeGameList)

        rlvCheatcode.layoutManager = layoutManagerCheatcodeGame
        rlvCheatcode.adapter = cheatCodeGameAdapter
    }
}