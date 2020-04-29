package cn.endureblaze.kirby.theme

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.GridView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import kotlin.reflect.KFunction0

/**
 * 主题的管理器
 * @param context 传入一个上下文用于初始化
 */
class ThemeManager(context: Context) {

    private var themeContext: Context = context
    private var themeShard: SharedPreferences = themeContext.getSharedPreferences(FILE_NAME, 0)

    companion object {
        const val FILE_NAME: String = "theme"
    }

    private val themeList = listOf(
        R.drawable.theme_blue,
        R.drawable.theme_red,
        R.drawable.theme_purple,
        R.drawable.theme_indigo,
        R.drawable.theme_teal,
        R.drawable.theme_green,
        R.drawable.theme_orange,
        R.drawable.theme_brown,
        R.drawable.theme_bluegrey,
        R.drawable.theme_yellow,
        R.drawable.theme_white,
        R.drawable.theme_dark,
        R.drawable.theme_pink
    )

    private val currThemeId get() = themeShard.getInt("themeId", 0)

    /**
     * 打开一个用于切换主题的对话框
     * @param callback 用于切换完毕后执行的一个函数，不能有返回值
     */
    fun showSwitchDialog(callback: () -> Unit) {
        val itemSelected: Int = currThemeId
        val switchDialog = AlertDialog.Builder(themeContext)
        switchDialog.setTitle("Theme")
        val adapter = ThemeListAdapter(themeContext, themeList)
        adapter.setCheckItem(itemSelected)
        val gridView: GridView = LayoutInflater.from(themeContext).inflate(R.layout.dialog_sw_theme, null) as GridView
        gridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        gridView.cacheColorHint = 0
        gridView.adapter = adapter
        switchDialog.setView(gridView)
        val dialog: AlertDialog = switchDialog.show()
        gridView.setOnItemClickListener { _, _, position, _ ->
            dialog.dismiss()
            if (itemSelected != position) {
                switchTheme(position)
                callback()
            }
        }
    }

    /**
     * 用于设置主题，直接链式调用即可
     */
    fun setAppTheme() {
        when (currThemeId) {
            ThemeEnum.BLUE_THEME -> themeContext.setTheme(R.style.BlueAppTheme)
            ThemeEnum.RED_THEME -> themeContext.setTheme(R.style.RedAppTheme)
            ThemeEnum.PURPLE_THEME -> themeContext.setTheme(R.style.PurpleAppTheme)
            ThemeEnum.Indigo_THEME -> themeContext.setTheme(R.style.IndigoAppTheme)
            ThemeEnum.TEAL_THEME -> themeContext.setTheme(R.style.TealAppTheme)
            ThemeEnum.GREEN_THEME -> themeContext.setTheme(R.style.GreenAppTheme)
            ThemeEnum.ORANGE_THEME -> themeContext.setTheme(R.style.OrangeAppTheme)
            ThemeEnum.BROWN_THEME -> themeContext.setTheme(R.style.BrownAppTheme)
            ThemeEnum.BLUEGREY_THEME -> themeContext.setTheme(R.style.BlueGreyAppTheme)
            ThemeEnum.YELLOW_THEME -> themeContext.setTheme(R.style.YellowAppTheme)
            ThemeEnum.WHITE_THEME -> themeContext.setTheme(R.style.WhiteAppTheme)
            ThemeEnum.DARK_THEME -> themeContext.setTheme(R.style.DarkAppTheme)
            ThemeEnum.PINK_THEME -> themeContext.setTheme(R.style.PinkAppTheme)
            else -> throw IllegalStateException("Unexpected value: $currThemeId")
        }
    }

    private fun switchTheme(theme_id: Int) = themeShard.edit { putInt("themeId", theme_id) }

    /**
     * 获取主题的一些颜色
     * @param id 需要获取的 id 值，例如 R.attr.colorPrimary
     */
    fun getThemeColorFromId(id: Int): Int {
        val typedValue = TypedValue()
        themeContext.theme.resolveAttribute(id, typedValue, true)
        return typedValue.data
    }

    /**
     * 获取系统是否为暗色模式
     */
    val isDarkMode: Boolean
        get() = (themeContext.resources.configuration.uiMode
                and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}