package cn.endureblaze.kirby.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Process
import androidx.appcompat.app.AlertDialog
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import cn.endureblaze.kirby.Launcher
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.utils.AppUtil
import cn.endureblaze.kirby.utils.LanguageUtil
import java.util.*

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings)
        activity?.let {
            findPreference<Preference>("version")?.summary =
                "(Build ${AppUtil(it).versionCode}) ${AppUtil(it).versionName} | ${AppUtil(it).packageName} | 先行测试版"
        }
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        when (preference?.key) {
            "star" -> star()
            "setLanguage" -> setLanguage()
            "apkCacheClean" -> apkCacheClean()
            "imageCacheClean" -> imageCacheClean()
            "faq" -> faq()
            "qq_group" -> qqGroup()
            "tg_channel" -> openUrl("https://t.me/kirbyassistant")
            "github" -> openUrl("https://github.com/KirbyAssistant/Kirby_Assistant_Kotlin")
            "dev_coolapk" -> openUrl("http://www.coolapk.com/u/651880")
            "dev_github" -> openUrl("https://github.com/EndureBlaze")
            "dev_weibo" -> openUrl("https://weibo.com/runanjing")
            "dev_twitter" -> openUrl("https://twitter.com/nihaocun?s=09")
            "domain_name" -> openUrl("http://www.shaoxudong.com/")
            "translation_tw" -> openUrl("https://github.com/longxk2017")
            "translation_en_1" -> openUrl("https://tieba.baidu.com/home/main?un=难难难550")
            "translation_en_2" -> openUrl("https://tieba.baidu.com/home/main?un=光之耀西")
            "draw_icon_1" -> openUrl("http://www.coolapk.com/u/555883")
            "draw_icon_2" -> openUrl("http://www.coolapk.com/u/529718")
            "draw_icon_3" -> openUrl("https://tieba.baidu.com/home/main?un=★☆小伊布☆★")
            "video_author" -> openUrl("http://space.bilibili.com/13001252")
            "writer_help_faq" -> openUrl("http://www.coolapk.com/u/1157774")
        }
        return super.onPreferenceTreeClick(preference)
    }

    private fun star() {
        val star = Intent("android.intent.action.VIEW")
        star.data = Uri.parse("market://details?id=cn.endureblaze.kirby")
        star.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity?.startActivity(star)
    }

    /**
     * 切换语言的方法
     */
    private fun setLanguage() {
        activity?.let {
            val lanList = arrayOf(
                "Auto", "简体中文", "繁體中文（台灣）", "ENGLISH"
            )
            AlertDialog.Builder(it)
                .setTitle(R.string.setting_language_title)
                .setSingleChoiceItems(
                    lanList,
                    LanguageUtil.getCheckedItem(it)
                ) { dialog, which ->
                    val lan = when (which) {
                        0 -> "auto"
                        1 -> "zh-rCN"
                        2 -> "zh-rTW"
                        3 -> "en"
                        else -> "auto"
                    }
                    LanguageUtil.setLanguage(it, lan)
                    dialog.dismiss()

                    val intent = Intent(activity, Launcher::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    activity!!.startActivity(intent)
                    Process.killProcess(Process.myPid())
                }
                .create()
                .show()
        }
    }

    private fun apkCacheClean() {
        TODO("Not yet implemented")
    }

    private fun imageCacheClean() {
        TODO("Not yet implemented")
    }

    private fun faq() {
        when (LanguageUtil.getSysLanguage()) {
            "zh-CN" -> openUrl("https://blog.endureblaze.cn/posts/ka_faq_cn/")
            "zh-TW" -> openUrl("https://blog.endureblaze.cn/posts/ka_faq_tw/")
            else -> openUrl("https://blog.endureblaze.cn/posts/ka_faq_en/")
        }
    }

    private fun qqGroup() {
        val key = "6j76WE8N9l378jnsWzmmUDv5HohOteHu"
        val joinQQ = Intent()
        joinQQ.data = Uri.parse(
            "mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D$key"
        )
        joinQQ.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        try {
            activity?.startActivity(joinQQ)
        } catch (e: Exception) {

        }
    }

    /**
     * 用浏览器打开一个链接
     * @param url 需要打开的链接
     */
    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        openUrl.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activity?.startActivity(openUrl)
    }
}