package com.example.openweatherapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.openweatherapp.model.WeatherItem
import com.example.openweatherapp.overview.OverViewViewModel

class DetailViewModelFactory(val weatherItem: WeatherItem) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(weatherItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
