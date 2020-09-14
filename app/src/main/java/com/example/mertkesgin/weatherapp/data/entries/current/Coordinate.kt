package com.example.mertkesgin.weatherapp.data.entries.current


import com.google.gson.annotations.SerializedName

data class Coordinate(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)