package com.example.mertkesgin.weatherapp.ui.currentweather

import android.text.format.DateFormat
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*


object CurrentWeatherBindings {

    @BindingAdapter("setDate")
    @JvmStatic
    fun converTimestampToDate(textView: TextView,timestamp:Long){
        val calendar = Calendar.getInstance(Locale.ENGLISH)
        calendar.timeInMillis = timestamp * 1000L
        val date = DateFormat.format("dd-MM-yyyy",calendar).toString()
        textView.text = "Updated at: ${date}"
    }

    @BindingAdapter("setHourAndMinute")
    @JvmStatic
    fun getHourAndMinute(textView: TextView,timestamp: Long){
        val calendar = Calendar.getInstance(Locale.ENGLISH)
        calendar.timeInMillis = timestamp * 1000L
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        textView.text = "${hour}:${minute}"
    }

    @BindingAdapter("setTemp")
    @JvmStatic
    fun getTemp(textView: TextView,temp:Double){
        val weatherTemp = "${temp} " + "℃"
        textView.text = weatherTemp
    }

    @BindingAdapter("setMinTemp")
    @JvmStatic
    fun getMinTemp(textView: TextView,temp:Double){
        val  minTemp = "Min temp: ${temp} " + "℃"
        textView.text = minTemp
    }

    @BindingAdapter("setMaxTemp")
    @JvmStatic
    fun getMaxTemp(textView: TextView,temp:Double){
        val  minTemp = "Max temp: ${temp} " + "℃"
        textView.text = minTemp
    }
}