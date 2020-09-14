package com.example.mertkesgin.weatherapp.ui.currentweather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mertkesgin.weatherapp.base.BaseViewModel
import com.example.mertkesgin.weatherapp.data.entries.CurrentWeatherResponse
import com.example.mertkesgin.weatherapp.repository.WeatherRepository
import com.example.mertkesgin.weatherapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class CurrentWeatherViewModel @ViewModelInject constructor(
    val weatherRepository: WeatherRepository
):BaseViewModel() {

    private val _currentWeather : MutableLiveData<Resource<CurrentWeatherResponse>> = MutableLiveData()
    val currentWeather: LiveData<Resource<CurrentWeatherResponse>>
        get() = _currentWeather

    init {
        getCurrentWeather()
    }

    fun getCurrentWeather() = viewModelScope.launch {
        _currentWeather.postValue(Resource.Loading())
        _currentWeather.postValue(getResult { weatherRepository.fetchCurrentWeather() })
    }
}