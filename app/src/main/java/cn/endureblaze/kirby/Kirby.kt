package cn.endureblaze.kirby

import android.app.Application
import android.content.Context
import com.bumptech.glide.request.RequestOptions

class Kirby : Application() {

    companion object {
        lateinit var context: Context

        fun getGlideRequestOptions(): RequestOptions {
            val requ = RequestOptions()
            requ.placeholder(R.drawable.ic_kirby_download)
                .error(R.drawable.ic_kirby_load_fail)
            return requ
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}