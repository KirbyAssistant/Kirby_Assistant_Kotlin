package cn.endureblaze.kirby.video

import android.os.Handler
import android.os.Message
import androidx.lifecycle.ViewModel
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.endureblaze.kirby.utils.ToastUtil
import java.lang.ref.WeakReference

class VideoViewModel : ViewModel() {

    val videoList: MutableList<Video> = ArrayList()

    /**
     * 获取视频数据的方法
     */
    fun getVideo(listener:GetVideoListener) {
        //请空列表
        videoList.clear()
        val bmobQuery: BmobQuery<BmobVideo> = BmobQuery()
        bmobQuery.findObjects(object : FindListener<BmobVideo>() {
            override fun done(list: MutableList<BmobVideo>?, e: BmobException?) {
                if (e == null) {
                    if (list != null) {
                        Thread() {
                            for (ele in list) {
                                //取出需要的数据
                                val videoUrl = ele.av
                                val videoTitle = ele.name
                                val videoImageUrl = ele.imageUrl
                                //添加进 data class
                                val videiItem = Video(videoTitle!!, videoImageUrl!!, videoUrl!!)
                                videoList.add(videiItem)
                                listener.setAdapter()
                            }
                        }.start()
                        listener.onFinish()
                    }
                } else {
                    listener.onFail(e)
                }
            }
        })
    }
}