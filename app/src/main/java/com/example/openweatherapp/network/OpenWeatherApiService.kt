package com.example.openweatherapp.network

import com.example.openweatherapp.model.WeatherData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface OpenWeatherApiService {
    @GET("data/2.5/forecast?lat=33&lon=18&appid=4c2b5bdd4b419670d2f79d0ad0c016ea")
    fun getFiveDayWeatherForecast(): Deferred<WeatherData>
}