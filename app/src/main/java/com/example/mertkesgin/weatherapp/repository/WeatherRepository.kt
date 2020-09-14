package com.example.mertkesgin.weatherapp.repository

import com.example.mertkesgin.weatherapp.data.local.UnitProvider
import com.example.mertkesgin.weatherapp.data.remote.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    val apiService: ApiService,
    val unitProvider: UnitProvider
){

    val location = unitProvider.getLocation()
    val unitSystem = unitProvider.getUnitSystem()

    suspend fun fetchCurrentWeather() = apiService.getCurrentWeather(location,unitSystem)

    suspend fun fetchtFiveDaysWeather() = apiService.getLastFiveDaysWeather(location,unitSystem)
}