package cn.endureblaze.kirby.setting

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.utils.AppUtil

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
            "" -> {
            }
        }

        return super.onPreferenceTreeClick(preference)
    }
}