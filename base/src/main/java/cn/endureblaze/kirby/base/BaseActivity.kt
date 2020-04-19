package cn.endureblaze.kirby.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.endureblaze.kirby.theme.ThemeManager
import cn.endureblaze.kirby.utils.ActManager

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActManager.addActivity(this)
        ThemeManager(this).setAppTheme()
    }
}
