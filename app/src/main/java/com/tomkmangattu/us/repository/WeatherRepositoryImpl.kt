package com.tomkmangattu.us.repository

import com.tomkmangattu.us.domain.model.WeatherData
import com.tomkmangattu.us.network.WeatherService
import com.tomkmangattu.us.network.model.WeatherDtoMapper
import javax.inject.Inject

class WeatherRepositoryImpl (
    private val weatherService: WeatherService,
    private val mapper: WeatherDtoMapper,
) :WeatherRepository {

    override suspend fun search(appid: String, cityName: String): WeatherData {
        return mapper.mapToDomainModel(weatherService.search(city = cityName, authId = appid))
    }

}