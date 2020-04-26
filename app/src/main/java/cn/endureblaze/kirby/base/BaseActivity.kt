package cn.endureblaze.kirby.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.endureblaze.kirby.theme.ThemeManager
import cn.endureblaze.kirby.utils.ActManager

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActManager.addActivity(this)
        ThemeManager(this).setAppTheme()
        //Bmob.initialize(CondomContext.wrap(this,"Bmob"),"e39c2e15ca40b358b0dcc933236c1165")
    }
}
