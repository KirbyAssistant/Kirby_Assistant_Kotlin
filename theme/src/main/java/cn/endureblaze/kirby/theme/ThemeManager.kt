package cn.endureblaze.kirby.theme

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.GridView
import androidx.appcompat.app.AlertDialog

class ThemeManager (context: Context) {

    private var themeContext: Context = context
    private var themeShard: SharedPreferences = themeContext.getSharedPreferences(FILE_NAME, 0)
    private var themeShardEdit: SharedPreferences.Editor = themeShard.edit()

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

    fun showSwitchDialog(callback: Unit) {
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
                callback
            }
        }
    }

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

    private fun switchTheme(theme_id: Int) = themeShardEdit.putInt("themeId", theme_id).apply()

    fun getThemeColorFromId(id: Int): Int {
        val typedValue = TypedValue()
        themeContext.theme.resolveAttribute(id, typedValue, true)
        return typedValue.data
    }

    val isDarkMode: Boolean
        get() = (themeContext.resources.configuration.uiMode
                and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}