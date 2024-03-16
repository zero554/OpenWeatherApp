package com.example.openweatherapp.network

import com.example.openweatherapp.model.WeatherData
import com.example.openweatherapp.model.WeatherItem
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

object Client {
    private const val BASE_URL = "http://api.openweathermap.org/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

    suspend fun getDailyForecast(): WeatherData? {
        return withContext(Dispatchers.IO) {
            try {
                retrofitService.getFiveDayWeatherForecast().await()
            } catch (e: Exception) {
                null
            }
        }
    }

    val retrofitService: OpenWeatherApiService by lazy {
        retrofit.create(OpenWeatherApiService::class.java)
    }

}