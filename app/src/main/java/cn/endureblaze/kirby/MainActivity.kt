package cn.endureblaze.kirby

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import cn.endureblaze.kirby.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
    }

    private fun initToolbar(){
        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setSubtitle(R.string.title_res)
    }

    private fun initFragmentPager(){

    }

    /**
     * 用于重置 MainActivity
     */
    private fun reloadMain(){
        val reloadMain = Intent(this,MainActivity::class.java)
        reloadMain.putExtra("theme",true)
        startActivity(reloadMain)
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        finish()
    }
}
