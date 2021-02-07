package work.manager.workmanagerexample

import android.content.Context

class SharedPreference(private val context: Context) {

    fun changeSwitch(value: Boolean) {
        val preferences = context.getSharedPreferences("WorkPref", Context.MODE_PRIVATE)
        preferences.edit().putBoolean("switch1", value).apply()
    }

    fun checkPrefs():Boolean {
        val preferences = context.getSharedPreferences("WorkPref", Context.MODE_PRIVATE)
        return preferences.getBoolean("switch1", true)
    }
}