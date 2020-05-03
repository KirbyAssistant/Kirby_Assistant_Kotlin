package cn.endureblaze.kirby.res.gamelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.base.BaseActivity
import cn.endureblaze.kirby.databinding.ActivityGameListBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding
import cn.endureblaze.kirby.res.dataclass.ResItem

class GameListActivity : BaseActivity() {

    private lateinit var viewModel: GameListViewModel

    companion object {
        private const val consoleTypeTag = "consoleType"
        private const val consoleNameTag = "consoleName"

        /**
         * 静态启动 GameListActivity 的方法
         * @param context 启动的上下文
         * @param consoleType 模拟器的名称
         */
        fun actionStart(context: Context, consoleType: String, consoleName: String) {
            val intent = Intent(context, GameListActivity::class.java)
            intent.putExtra(consoleTypeTag, consoleType)
            intent.putExtra(consoleNameTag, consoleName)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[GameListViewModel::class.java]
        viewModel.binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(viewModel.binding.root)
        initToolbar()
        initGameListData()
    }

    /**
     * 初始化 Toolbar
     */
    private fun initToolbar() {
        viewModel.toolbarBinding = LayoutToolbarBinding.bind(viewModel.binding.root)
        setSupportActionBar(viewModel.toolbarBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title =
            "${resources.getString(R.string.title_game_list)} ${intent.getStringExtra(consoleNameTag)}"
    }

    /**
     * 根据 consoleNameTag 加载列表
     */
    private fun initGameListData() {
        val layoutManager = GridLayoutManager(this, 1)
        val tag = intent.getStringExtra(consoleTypeTag)
        tag?.let {
            val adapter = GameListAdapter(viewModel.getGameList(it), viewModel)
            viewModel.binding.gameList.layoutManager = layoutManager
            viewModel.binding.gameList.adapter = adapter
        }

    }
}
