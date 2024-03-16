package com.example.openweatherapp.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.openweatherapp.converters.*
import com.example.openweatherapp.model.*


@Database(
    entities = [WeatherData::class],
    version = 46,
    exportSchema = false
)

@TypeConverters(WeatherItemLstTypeConverter::class, MainTypeConverter::class, WeatherTypeConverter::class, WeatherLstTypeConverter::class, CityTypeConverter::class, CoordTypeConverter::class, WeatherDataConverter::class)
abstract class WeatherItemDatabase : RoomDatabase() {
    abstract val weatherItemDatabaseDao: WeatherItemDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: WeatherItemDatabase? = null

        fun getDatabase(context: Context): WeatherItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherItemDatabase::class.java,
                    "open_weather_app_26_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}