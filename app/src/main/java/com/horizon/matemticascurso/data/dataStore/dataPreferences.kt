package com.horizon.matemticascurso.data.dataStore

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import com.horizon.matemticascurso.data.model.UserState

class DataPreferences(context: Context) {
    private val userState = UserState()
    companion object {
        private const val PREFS_NAME = "user_prefs"
        private const val KEY_INDEXCOLOR = "index_color"
        private const val KEY_MODE = "theme_mode"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveSelectedColor(index: Int) {
        sharedPreferences.edit().putInt(KEY_INDEXCOLOR, index).apply()
    }

    fun getSelectedColor() : Int {
        return sharedPreferences.getInt(KEY_INDEXCOLOR, userState.indexColor)
    }

    fun saveThemeMode(isDarkTheme: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_MODE, isDarkTheme).apply()
    }

    fun getThemeMode() : Boolean {
        return sharedPreferences.getBoolean(KEY_MODE, true)
    }

    /* fun saveLives(lives: Int) {
        sharedPreferences.edit().putInt(KEY_LIVES, lives).apply()
    }

    fun getLives(): Int {
        return sharedPreferences.getInt(KEY_LIVES, 3) // Valor predeterminado 3 si no se encuentra
    }

    fun saveLastUpdateTime(time: Int) {
        sharedPreferences.edit().putInt(KEY_LASTUPDATE, time).apply()
    }

    fun getLastUpdateTime(): Int {
        val defaultValue = System.currentTimeMillis().toInt()
        return sharedPreferences.getInt(KEY_LASTUPDATE, defaultValue)
    }

    /*fun getLastUpdateTime(): Long {
        val defaultValue = System.currentTimeMillis()
        return if (sharedPreferences.contains(KEY_LASTUPDATE)) {
            try {
                sharedPreferences.getLong(KEY_LASTUPDATE, defaultValue)
            } catch (e: ClassCastException) {
                sharedPreferences.getInt(KEY_LASTUPDATE, defaultValue.toInt()).toLong()
            }
        } else {
            defaultValue
        }
    } */

    fun saveCurrentTime(currentTime: Long) {
        sharedPreferences.edit().putLong(KEY_TIMER, currentTime).apply()
    }

    fun getCurrentTime() : Long {
        val currentTime = System.currentTimeMillis()
        return sharedPreferences.getLong(KEY_TIMER, currentTime)
    } */
}