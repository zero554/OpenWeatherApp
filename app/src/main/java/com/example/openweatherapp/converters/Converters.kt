package com.example.openweatherapp.converters

import androidx.room.TypeConverter
import com.example.openweatherapp.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class WeatherLstTypeConverter {
    @TypeConverter
    fun toLst(string: String): List<Weather> {
        val lstType = object: TypeToken<List<Weather>>(){}.type
        return Gson().fromJson(string, lstType)
    }

    @TypeConverter
    fun fromLst(lst: List<Weather>): String {
        return Gson().toJson(lst)
    }
}

class WeatherItemLstTypeConverter {
    @TypeConverter
    fun toLst(string: String): List<WeatherItem> {
        val lstType = object: TypeToken<List<WeatherItem>>(){}.type
        return Gson().fromJson(string, lstType)
    }

    @TypeConverter
    fun fromLst(lst: List<WeatherItem>): String {
        return Gson().toJson(lst)
    }
}

class MainTypeConverter {
    @TypeConverter
    fun toMain(string: String): Main {
        val mainType = object: TypeToken<Main>(){}.type
        return Gson().fromJson(string, mainType)
    }

    @TypeConverter
    fun fromMain(main: Main): String {
        return Gson().toJson(main)
    }
}

class WeatherTypeConverter {
    @TypeConverter
    fun toWeather(string: String): Weather {
        val lstType = object: TypeToken<List<Weather>>(){}.type
        return Gson().fromJson(string, lstType)
    }

    @TypeConverter
    fun fromWeather(weather: Weather): String {
        return Gson().toJson(weather)
    }
}

class WeatherDataConverter {
    @TypeConverter
    fun toWeatherData(string: String): WeatherData {
        val weatherData = object: TypeToken<WeatherData>(){}.type
        return Gson().fromJson(string, weatherData)
    }

    @TypeConverter
    fun fromWeather(weatherData: WeatherData): String {
        return Gson().toJson(weatherData)
    }
}

class CityTypeConverter {
    @TypeConverter
    fun toCity(string: String): City {
        val city = object : TypeToken<City>() {}.type
        return Gson().fromJson(string, city)
    }

    @TypeConverter
    fun fromCity(city: City): String {
        return Gson().toJson(city)
    }
}

class CoordTypeConverter {
    @TypeConverter
    fun toCoord(string: String): Coord {
        val coord = object : TypeToken<Coord>() {}.type
        return Gson().fromJson(string, coord)
    }

    @TypeConverter
    fun fromCoord(coord: Coord): String {
        return Gson().toJson(coord)
    }
}