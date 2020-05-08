package cn.endureblaze.kirby.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import cn.bmob.v3.Bmob
import cn.endureblaze.kirby.theme.ThemeManager
import cn.endureblaze.kirby.utils.ActManager
import cn.endureblaze.kirby.utils.ContextWrapper
import cn.endureblaze.kirby.utils.LanguageUtil
import com.oasisfeng.condom.CondomContext
import java.util.*

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity this is",javaClass.simpleName)
        ActManager.addActivity(this)
        ThemeManager(this).setAppTheme()
        Bmob.initialize(CondomContext.wrap(this,"Bmob"),"e39c2e15ca40b358b0dcc933236c1165")
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun attachBaseContext(newBase: Context?) {
        val context = newBase?.let { ContextWrapper.wrap(newBase,LanguageUtil.getLocale(newBase)) }
        super.attachBaseContext(context)
    }
}
