package com.example.openweatherapp.overview

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.openweatherapp.MainCoroutineRule
import com.example.openweatherapp.model.City
import com.example.openweatherapp.model.Coord
import com.example.openweatherapp.model.WeatherData
import com.example.openweatherapp.repository.OpenWeatherRepository
import com.example.openweatherapp.repository.OpenWeatherAppApiStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class OverViewViewModelTest {
    private lateinit var overViewViewModel: OverViewViewModel
    private lateinit var repositoryMock: OpenWeatherRepository

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() = mainCoroutineRule.runBlockingTest {
        repositoryMock = mock(OpenWeatherRepository::class.java)
        overViewViewModel = OverViewViewModel(repositoryMock)
    }

    @Test
    fun `get weatherData from empty database returns empty list`() {
        val lst = MutableLiveData<List<WeatherData>>(listOf())
        `when`(repositoryMock.getWeatherData()).thenReturn(lst as LiveData<List<WeatherData>>)
        val weatherData = overViewViewModel.getWeatherDataFromDatasource().value
        assertEquals(lst.value, weatherData)
    }

    @Test
    fun `get weatherData from populated database returns populated list`() {
        val wd = WeatherData(
            listOf(),
            City("London", Coord(0.0, 0.0), "Great Britain", 0.0, 0.0, 0.0)
        )
        val lst = MutableLiveData(listOf(wd))
        `when`(repositoryMock.getWeatherData()).thenReturn(lst as LiveData<List<WeatherData>>)
        val weatherData = overViewViewModel.getWeatherDataFromDatasource().value?.find { it == wd }
        assertEquals(weatherData, wd)
    }

    @Test
    fun `get api status when api call failed given there is no network (airplane mode)`() {
        val expectedStatus = MutableLiveData(OpenWeatherAppApiStatus.ERROR)
        `when`(repositoryMock.getApiStatus()).thenReturn(expectedStatus)
        val status = overViewViewModel.getApiStatus().value
        assertEquals(expectedStatus.value, status)
    }

    @Test
    fun `get api status when api call succeeded`() {
        val expectedStatus = MutableLiveData(OpenWeatherAppApiStatus.DONE)
        `when`(repositoryMock.getApiStatus()).thenReturn(expectedStatus)
        val status = overViewViewModel.getApiStatus().value
        assertEquals(expectedStatus.value, status)
    }

    @Test
    fun `get api status before refreshCache function call returns LOADING enum`() {
        val expectedStatus = MutableLiveData(OpenWeatherAppApiStatus.LOADING)
        `when`(repositoryMock.getApiStatus()).thenReturn(expectedStatus)
        val status = overViewViewModel.getApiStatus().value
        assertEquals(expectedStatus.value, status)
    }
}
