package cn.endureblaze.kirby.video

import cn.bmob.v3.exception.BmobException

interface GetVideoListener {
    fun onFinish()
    fun setAdapter()
    fun onFail(e: BmobException)
}