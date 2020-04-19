package cn.endureblaze.kirby

import android.os.Bundle
import cn.endureblaze.kirby.base.BaseActivity
import cn.endureblaze.kirby.theme.ThemeManager
import cn.endureblaze.kirby.utils.ToastUtil

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ThemeManager(this).showSwitchDialog(test())
    }
    private fun test(){
        ToastUtil.show("yyyyy")
    }
}
