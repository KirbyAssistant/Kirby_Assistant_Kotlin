package cn.endureblaze.kirby.ui.video

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.base.BaseFragment
import cn.endureblaze.kirby.databinding.FragmentVideoBinding
import cn.endureblaze.kirby.theme.ThemeManager
import cn.endureblaze.kirby.utils.ToastUtil
import com.scwang.smart.refresh.header.MaterialHeader

class VideoFragment : BaseFragment<FragmentVideoBinding, VideoViewModel>(R.layout.fragment_video) {

    private var adapter: VideoAdapter? = null

    override fun initBinding(view: View): FragmentVideoBinding = FragmentVideoBinding.bind(view)

    override fun initViewModel(): VideoViewModel = ViewModelProvider(this)[VideoViewModel::class.java]

    override fun initView() {
        val header: MaterialHeader = binding.videoRefresh.refreshHeader as MaterialHeader
        activity?.let { header.setColorSchemeColors(ThemeManager(it).getThemeColorFromId(R.attr.colorAccent)) }

        val layoutManager = GridLayoutManager(activity, 2)
        binding.videoList.layoutManager = layoutManager
        adapter = VideoAdapter(viewModel.videoList)
    }

    override fun loadDate() {
        binding.videoRefresh.setEnableNestedScroll(true)
        binding.videoRefresh.autoRefresh()
        binding.videoRefresh.setOnRefreshListener {
            it.setEnableLoadMore(false)
            viewModel.getVideo({
                it.setEnableLoadMore(true)
                binding.videoLoadFailText.visibility = View.GONE
                binding.videoList.adapter = adapter
                it.finishRefresh()
            },{e ->
                e.message?.let { msg -> ToastUtil.show(msg) }
                binding.videoLoadFailText.visibility = View.VISIBLE
                it.finishRefresh()
                binding.videoLoadFailText.text = "${activity?.resources?.getString(R.string.load_fail)} \n ${e.message}"
            })
        }
    }
}