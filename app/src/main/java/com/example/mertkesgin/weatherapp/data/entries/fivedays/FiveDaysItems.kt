package com.example.mertkesgin.weatherapp.data.entries.fivedays

import com.example.mertkesgin.weatherapp.data.entries.current.Main
import com.example.mertkesgin.weatherapp.data.entries.current.Weather
import com.example.mertkesgin.weatherapp.data.entries.current.Wind
import com.google.gson.annotations.SerializedName

data class FiveDaysItems(
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
}