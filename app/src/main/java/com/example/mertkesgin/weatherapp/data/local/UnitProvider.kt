package com.example.mertkesgin.weatherapp.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.mertkesgin.weatherapp.utils.Constant.DEFAULT_LOCATION_VALUE
import com.example.mertkesgin.weatherapp.utils.Constant.LOCATION_KEY
import com.example.mertkesgin.weatherapp.utils.Constant.UNIT_SYSTEM_DEFAULT_VALUE
import com.example.mertkesgin.weatherapp.utils.Constant.UNIT_SYSTEM_KEY

class UnitProvider(context: Context) {
    private val appContext = context.applicationContext

    private val preferences:SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun getLocation(): String{
        val selectedLocation = preferences.getString(LOCATION_KEY, DEFAULT_LOCATION_VALUE)
        return selectedLocation!!
    }

    fun getUnitSystem(): String{
        val unitSystem = preferences.getString(UNIT_SYSTEM_KEY, UNIT_SYSTEM_DEFAULT_VALUE)
        return unitSystem!!
    }
}