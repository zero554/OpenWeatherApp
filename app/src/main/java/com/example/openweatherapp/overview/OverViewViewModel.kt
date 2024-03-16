package com.example.openweatherapp.overview

import androidx.lifecycle.*
import com.example.openweatherapp.model.WeatherData
import com.example.openweatherapp.repository.OpenWeatherRepository
import com.example.openweatherapp.repository.OpenWeatherAppApiStatus
import kotlinx.coroutines.launch


class OverViewViewModel(val repository: OpenWeatherRepository) : ViewModel() {
    val weatherData = getWeatherDataFromDatasource()
    val status = getApiStatus()

    init {
        refreshCache()
    }

    fun refreshCache() {
        viewModelScope.launch { repository.refreshCache() }
    }

    fun getWeatherDataFromDatasource():LiveData<List<WeatherData>> = repository.getWeatherData()

    fun getApiStatus(): LiveData<OpenWeatherAppApiStatus> = repository.getApiStatus()


}