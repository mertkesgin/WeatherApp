package com.example.mertkesgin.weatherapp.data.entries


import com.example.mertkesgin.weatherapp.data.entries.fivedays.City
import com.example.mertkesgin.weatherapp.data.entries.fivedays.FiveDaysItems
import com.google.gson.annotations.SerializedName

data class FiveDaysWeatherResponse(
    @SerializedName("city")
    val city: City,

    @SerializedName("cod")
    val cod: String,

    @SerializedName("list")
    val list: List<FiveDaysItems>,

    @SerializedName("message")
    val message: Int
)