package com.example.mertkesgin.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mertkesgin.weatherapp.R
import com.example.mertkesgin.weatherapp.data.entries.fivedays.FiveDaysItems
import com.example.mertkesgin.weatherapp.utils.Constant.IMAGE_BASE
import com.example.mertkesgin.weatherapp.utils.Constant.IMAGE_END
import com.example.mertkesgin.weatherapp.utils.ImageHelper
import kotlinx.android.synthetic.main.item_fivedays_weather.view.*

class FiveDaysWeatherAdapter : RecyclerView.Adapter<FiveDaysWeatherAdapter.FiveDaysViewHolder>() {

    inner class FiveDaysViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    val differCallback = object : DiffUtil.ItemCallback<FiveDaysItems>(){
        override fun areItemsTheSame(oldItem: FiveDaysItems, newItem: FiveDaysItems): Boolean {
            return oldItem.dtTxt == newItem.dtTxt
        }

        override fun areContentsTheSame(oldItem: FiveDaysItems, newItem: FiveDaysItems): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiveDaysViewHolder {
        return FiveDaysViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_fivedays_weather,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: FiveDaysViewHolder, position: Int) {
        val singleWeather = differ.currentList[position]
        holder.itemView.apply {
            tvDate.text = singleWeather.dtTxt
            tvItemTemp.text = "${singleWeather.main.temp} "
            ImageHelper().loadUrl(IMAGE_BASE+singleWeather.weather[0].icon+ IMAGE_END,img_item)
        }

    }
}