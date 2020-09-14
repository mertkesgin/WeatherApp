package com.example.mertkesgin.weatherapp.data.entries.current


import com.google.gson.annotations.SerializedName

data class Main(

    @SerializedName("humidity")
    val humidity: String,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("temp")
    val temp: Double,

    @SerializedName("feels_like")
    val feelsLike: Double,

    @SerializedName("temp_max")
    val tempMax: Double,

    @SerializedName("temp_min")
    val tempMin: Double
)