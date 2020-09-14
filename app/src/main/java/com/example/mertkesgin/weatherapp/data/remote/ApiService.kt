package com.example.mertkesgin.weatherapp.data.remote

import com.example.mertkesgin.weatherapp.data.entries.CurrentWeatherResponse
import com.example.mertkesgin.weatherapp.data.entries.FiveDaysWeatherResponse
import com.example.mertkesgin.weatherapp.utils.Constant
import com.example.mertkesgin.weatherapp.utils.Constant.API_ENDPOINT_5DAYS
import com.example.mertkesgin.weatherapp.utils.Constant.API_ENDPOINT_CURRENT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(API_ENDPOINT_CURRENT)
    suspend fun getCurrentWeather(
        @Query("q") location:String,
        @Query("units") unitSystem:String,
        @Query("appid") apiKey: String = Constant.API_KEY
    ): Response<CurrentWeatherResponse>

    @GET(API_ENDPOINT_5DAYS)
    suspend fun getLastFiveDaysWeather(
        @Query("q") location: String,
        @Query("units") unitSystem:String,
        @Query("appid") apiKey: String = Constant.API_KEY
    ): Response<FiveDaysWeatherResponse>
}