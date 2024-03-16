package com.example.openweatherapp.model

import android.os.Parcelable
import androidx.room.*
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

@Entity(tableName = "weather_data_table")
data class WeatherData(@ColumnInfo(name = "weather_items") val list: List<WeatherItem>, @ColumnInfo(name = "city") val city: City) {
    @PrimaryKey(autoGenerate = true) var id = 0
}

@Parcelize
data class WeatherItem(
    @SerializedName("dt") val dateTime: Double,
    val main: Main,
    val weather: List<Weather>,
    @SerializedName("dt_txt") val dateTimeText: String
) : Parcelable


@Parcelize
data class Main(val temp: Double, @SerializedName("temp_min") val tempMin: Double) : Parcelable

@Parcelize
data class Weather(val main: String, val description: String) : Parcelable

data class City(
    val name: String,
    val coord: Coord,
    val country: String,
    val timezone: Double,
    val sunrise: Double,
    val sunset: Double
)

data class Coord(val lat: Double, val lon: Double)