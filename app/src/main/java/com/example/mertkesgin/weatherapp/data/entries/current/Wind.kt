package com.example.mertkesgin.weatherapp.data.entries.current


import com.google.gson.annotations.SerializedName

data class Wind(

    @SerializedName("deg")
    val deg: Int,

    @SerializedName("speed")
    val speed: String
)