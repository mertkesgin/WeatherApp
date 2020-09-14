package com.example.mertkesgin.weatherapp.data.entries.current


import com.google.gson.annotations.SerializedName

data class CountryInfo(

    @SerializedName("country")
    val country: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("sunrise")
    val sunrise: Long,

    @SerializedName("sunset")
    val sunset: Long
)