package cn.endureblaze.kirby.res.cheatcode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.base.BaseActivity
import cn.endureblaze.kirby.databinding.ActivityCheatCodeBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding

class CheatCodeActivity : BaseActivity() {

    private lateinit var viewModel: CheatCodeViewModel

    companion object {
        private const val gameTag = "gameTag"

        /**
         * 静态启动 CheatCodeActivity 的方法
         * @param context 启动的上下文
         * @param tag 游戏的 tag
         */
        fun actionStart(context: Context, tag: String) {
            val intent = Intent(context, CheatCodeActivity::class.java)
            intent.putExtra(gameTag, tag)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CheatCodeViewModel::class.java]
        viewModel.binding = ActivityCheatCodeBinding.inflate(layoutInflater)
        setContentView(viewModel.binding.root)
        initToolbar()
        initCheatCode()
    }

    /**
     * 初始化 Toolbar
     */
    private fun initToolbar() {
        viewModel.toolbarBinding = LayoutToolbarBinding.bind(viewModel.binding.root)
        setSupportActionBar(viewModel.toolbarBinding.toolbar)
        supportActionBar?.title = getString(R.string.tab_cheatcode)
    }

    private fun initCheatCode() {
        val tag = intent.getStringExtra(gameTag)
        tag?.let {
            val adaper = CheatCodeAdapter(this, viewModel.getCheatCodeData(it))
            viewModel.binding.cheatcodeList.adapter = adaper
        }
    }
}
