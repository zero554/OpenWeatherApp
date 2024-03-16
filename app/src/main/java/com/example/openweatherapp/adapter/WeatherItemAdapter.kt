package com.example.openweatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.databinding.WeatherItemBinding
import com.example.openweatherapp.model.WeatherItem

class WeatherItemAdapter(val weatherItemListener: WeatherItemListener) :
    ListAdapter<WeatherItem, WeatherItemAdapter.ViewHolder>(WeatherItemDiffUtill()) {

    class ViewHolder private constructor(val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherItem: WeatherItem, weatherItemListener: WeatherItemListener) {
            binding.weatherItem = weatherItem
            binding.weatherItemListener = weatherItemListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = WeatherItemBinding.inflate(layoutInflater)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weatherItem = getItem(position)
        holder.bind(weatherItem, weatherItemListener)
    }

}

class WeatherItemDiffUtill : DiffUtil.ItemCallback<WeatherItem>() {
    override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
        return oldItem.dateTimeText == newItem.dateTimeText
    }

    override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
        return oldItem == newItem
    }
}

class WeatherItemListener(val clickListener: (WeatherItem) -> Unit) {
    fun onClick(weatherItem: WeatherItem) {
        clickListener(weatherItem)
    }
}


