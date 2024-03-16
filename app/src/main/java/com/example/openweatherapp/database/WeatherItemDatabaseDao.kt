package com.example.openweatherapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.openweatherapp.model.WeatherData
import com.example.openweatherapp.model.WeatherItem

@Dao
interface WeatherItemDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherData: WeatherData)

    @Query("SELECT * FROM weather_data_table")
    fun getWeatherData(): LiveData<List<WeatherData>>

    @Query("DELETE FROM weather_data_table")
    suspend fun clear()
}