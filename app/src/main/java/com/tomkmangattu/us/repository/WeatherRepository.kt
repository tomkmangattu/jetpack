package com.tomkmangattu.us.repository

import com.tomkmangattu.us.domain.model.WeatherData

interface WeatherRepository {

    suspend fun search(appid : String, cityName: String) : WeatherData
}