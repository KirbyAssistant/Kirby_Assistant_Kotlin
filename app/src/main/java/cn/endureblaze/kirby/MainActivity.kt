package cn.endureblaze.kirby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import cn.endureblaze.kirby.adapter.ViewPagerAdapter
import cn.endureblaze.kirby.base.BaseActivity
import cn.endureblaze.kirby.databinding.ActivityMainBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding
import cn.endureblaze.kirby.res.MainResFragment
import cn.endureblaze.kirby.theme.ThemeManager

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    companion object {
        /**
         * 静态启动 MainActivity 的方法
         * @param context 启动的上下文
         */
        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewModel.binding.root)
        initToolbar()
        initFragmentPager()
        initBottomBar()
    }

    /**
     * 重写初始化 Toolbar 菜单的方法
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar, menu)
        return true
    }

    /**
     * 重写 Toolbar 菜单选中的方法
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.theme -> ThemeManager(this).showSwitchDialog(::reloadMain)
        }
        return true
    }

    /**
     * 初始化 Toolbar
     */
    private fun initToolbar() {
        viewModel.toolbarBinding =  LayoutToolbarBinding.bind(viewModel.binding.root)
        setSupportActionBar(viewModel.toolbarBinding.toolbar)
        viewModel.toolbarBinding.toolbar.setSubtitle(R.string.title_res)
    }

    /**
     * 初始化 Fragment
     */
    private fun initFragmentPager() {
        val mainResFragment = MainResFragment()

        viewModel.fragmentList.add(mainResFragment)
        viewModel.pagerTitleList.add(resources.getString(R.string.title_res))

        viewModel.mainFragmentViewPager = viewModel.binding.mainFragmentViewpager
        viewModel.mainFragmentViewPager.adapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            viewModel.fragmentList
        )
        viewModel.mainFragmentViewPager.setScroll(false)
        viewModel.mainFragmentViewPager.offscreenPageLimit = 4
    }

    /**
     * 初始化底栏
     */
    private fun initBottomBar() {
        val bottomNavigationView = viewModel.binding.mainBottomNavigationBar
        bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.res -> {
                    viewModel.mainFragmentViewPager.currentItem = 0
                    viewModel.toolbarBinding.toolbar.subtitle = viewModel.pagerTitleList[0]
                }
            }

            return@setOnNavigationItemSelectedListener true
        }
        // 为ViewPager添加页面改变事件
        viewModel.mainFragmentViewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // 将当前的页面对应的底部标签设为选中状态
                bottomNavigationView.menu.getItem(position).isChecked = true
                viewModel.fragmentPos = position
            }

            override fun onPageSelected(position: Int) {

            }

        })
    }

    /**
     * 用于重置 MainActivity
     */
    private fun reloadMain() {
        val reloadMain = Intent(this, MainActivity::class.java)
        reloadMain.putExtra("theme", true)
        startActivity(reloadMain)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}
