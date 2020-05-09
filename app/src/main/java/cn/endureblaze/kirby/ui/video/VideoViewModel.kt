package cn.endureblaze.kirby.ui.video

import androidx.lifecycle.ViewModel
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.endureblaze.kirby.logic.bmob.BmobVideo
import cn.endureblaze.kirby.logic.model.Video
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VideoViewModel : ViewModel() {

    val videoList: MutableList<Video> = ArrayList()

    /**
     * 获取视频数据的方法
     */
    fun getVideo(onFinish: () -> Unit, onFail: (BmobException) -> Unit) {
        //请空列表
        videoList.clear()
        val bmobQuery: BmobQuery<BmobVideo> = BmobQuery()
        bmobQuery.findObjects(object : FindListener<BmobVideo>() {
            override fun done(list: MutableList<BmobVideo>?, e: BmobException?) {
                if (e == null) {
                    if (list != null) {
                        GlobalScope.launch(Dispatchers.Main) {
                            withContext(Dispatchers.IO) {
                                for (ele in list) {
                                    //取出需要的数据
                                    val videoUrl = ele.av
                                    val videoTitle = ele.name
                                    val videoImageUrl = ele.imageUrl
                                    //添加进 data class
                                    val videiItem = Video(
                                        videoTitle!!,
                                        videoImageUrl!!,
                                        videoUrl!!
                                    )
                                    videoList.add(videiItem)
                                }
                            }
                            onFinish()
                        }
                    }
                } else {
                    onFail(e)
                }
            }
        })
    }
}