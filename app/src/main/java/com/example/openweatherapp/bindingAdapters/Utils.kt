package com.example.openweatherapp.bindingAdapters

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.R
import com.example.openweatherapp.adapter.WeatherItemAdapter
import com.example.openweatherapp.model.Main
import com.example.openweatherapp.model.Weather
import com.example.openweatherapp.model.WeatherData
import com.example.openweatherapp.model.WeatherItem
import com.example.openweatherapp.repository.OpenWeatherAppApiStatus
import java.lang.Exception
import java.util.*

@BindingAdapter("status", "weatherData")
fun TextView.setStatus(status: OpenWeatherAppApiStatus, weatherData: List<WeatherData>?) {
    when (status) {
        OpenWeatherAppApiStatus.LOADING -> {
            if (weatherData?.size == 0) {
                text = "LOADING"
            }
            else {
                text = ""
            }
        }
        OpenWeatherAppApiStatus.DONE -> visibility = View.GONE
        else -> {
            if (weatherData?.isNullOrEmpty() == true) text = "No Service! Could not load data"
        }
    }
}

@BindingAdapter("weatherData", "weatherItemAdapter", requireAll = true)
fun RecyclerView.setWeatherData(
    weatherData: List<WeatherData>?,
    weatherItemAdapter: WeatherItemAdapter
) {
    if (weatherData?.isNullOrEmpty() == true) weatherItemAdapter.submitList(listOf())
    else weatherData?.let { weatherItemAdapter.submitList(it[0].list) }

}

@BindingAdapter("icon", "inDetail", requireAll = false)
fun ImageView.setIcon(weather: Weather, inDetail: Boolean = false) {
    if (inDetail == false) when (weather.main) {
        "Clouds" -> setImageResource(R.drawable.ic_cloudy)
        "Rain" -> setImageResource(R.drawable.ic_rain)
        else -> setImageResource(R.drawable.ic_clear)
    }
    else when (weather.main) {
        "Clouds" -> setImageResource(R.drawable.art_clouds)
        "Rain" -> setImageResource(R.drawable.art_rain)
        else -> setImageResource(R.drawable.art_clear)
    }
}

@BindingAdapter("day")
fun TextView.setDay(string: String) {
    // 2022-04-14 00:00:00
    val str = string.replace('-', '/')
    val date = Date(str.split(" ")[0])
    val time = string.split(" ")[1]
    val today = Date()

    if (date.date == today.date) {
        text = "Today ${time}"
    } else {
        text = "${date.toString().split(" ")[0]} ${time}"
    }

}

@BindingAdapter("details", "month", requireAll = false)
fun TextView.setMonth(string: String, month: Boolean = false) {
    // 2022-04-14 00:00:00
    val str = string.replace('-', '/')
    val date = Date(str.split(" ")[0])
    val time = string.split(" ")[1]
    val today = Date()

    val day = when (date.toString().split(" ")[0]) {
        "Mon" -> "Monday"
        "Tue" -> "Tuesday"
        "Wed" -> "Wednesday"
        "Thu" -> "Thursday"
        "Fri" -> "Friday"
        "Sat" -> "Saturday"
        else -> "Sunday"
    }

    // month
    val m = when (date.toString().split(" ")[1]) {
        "Jan" -> "January"
        "Feb" -> "February"
        "Mar" -> "March"
        "Apr" -> "April"
        "Jun" -> "June"
        "Jul" -> "July"
        "Aug" -> "August"
        "Sep" -> "September"
        "Oct" -> "October"
        "Nov" -> "November"
        "Dec" -> "December"
        else -> "May"
    }

    if (month) {
        text = "$m ${date.toString().split(" ")[2]}"
    } else {
        text = "$day $time"
    }

}

@BindingAdapter("temp", "min", "inDetail", requireAll = false)
fun TextView.setTemp(main: Main, min: Boolean = false, inDetail: Boolean = false) {
    when (min) {
        false -> {
            if (!inDetail) {
                text = "${main.temp.toString()}°"
            } else {
                text = "H: ${main.temp.toString()}°"
            }
        }
        else -> {
            if (!inDetail) {
                text = "${main.tempMin.toString()}°"
            } else {
                text = "L: ${main.tempMin.toString()}°"
            }
        }
    }
}
