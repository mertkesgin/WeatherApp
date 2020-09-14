package com.example.mertkesgin.weatherapp.ui.fivedaysweather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mertkesgin.weatherapp.base.BaseViewModel
import com.example.mertkesgin.weatherapp.data.entries.CurrentWeatherResponse
import com.example.mertkesgin.weatherapp.data.entries.FiveDaysWeatherResponse
import com.example.mertkesgin.weatherapp.repository.WeatherRepository
import com.example.mertkesgin.weatherapp.utils.Resource
import kotlinx.coroutines.launch

class FiveDaysWeatherViewModel @ViewModelInject constructor(
    val weatherRepository: WeatherRepository
): BaseViewModel() {

    private val _fiveDaysWeather : MutableLiveData<Resource<FiveDaysWeatherResponse>> = MutableLiveData()
    val fiveDaysWeather: LiveData<Resource<FiveDaysWeatherResponse>>
        get() = _fiveDaysWeather

    init {
        getFiveDaysWeather()
    }

    fun getFiveDaysWeather() = viewModelScope.launch {
        _fiveDaysWeather.postValue(Resource.Loading())
        _fiveDaysWeather.postValue(getResult { weatherRepository.fetchtFiveDaysWeather() })
    }
}