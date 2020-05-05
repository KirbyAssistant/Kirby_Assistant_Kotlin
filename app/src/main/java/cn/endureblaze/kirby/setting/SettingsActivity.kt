package cn.endureblaze.kirby.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.endureblaze.kirby.MainActivity
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.base.BaseActivity
import cn.endureblaze.kirby.databinding.ActivitySettingBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding

class SettingsActivity: BaseActivity() {

    private lateinit var binding: ActivitySettingBinding

    companion object {
        /**
         * 静态启动 SettingsActivity 的方法
         * @param context 启动的上下文
         */
        fun actionStart(context: Context) {
            val intent = Intent(context, SettingsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        initSetting()
    }

    private fun initToolbar() {
        val toolbarBinding =  LayoutToolbarBinding.bind(binding.root)
        setSupportActionBar(toolbarBinding.toolbar)
        supportActionBar?.title = getString(R.string.setting_title)
    }

    private fun initSetting() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.settingFragment.id, SettingsFragment())
            .commit()
    }
}