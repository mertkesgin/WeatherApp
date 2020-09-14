package com.example.mertkesgin.weatherapp.data.entries


import com.example.mertkesgin.weatherapp.data.entries.current.*
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    @SerializedName("base")
    val base: String,

    @SerializedName("cod")
    val cod: Int,

    @SerializedName("coord")
    val coordinate: Coordinate,

    @SerializedName("dt")
    val timestamp: Long,

    @SerializedName("id")
    val id: Int,

    @SerializedName("main")
    val main: Main,

    @SerializedName("name")
    val name: String,

    @SerializedName("sys")
    val countryInfo: CountryInfo,

    @SerializedName("visibility")
    val visibility: Int,

    @SerializedName("weather")
    val weather: List<Weather>,

    @SerializedName("wind")
    val wind: Wind
)