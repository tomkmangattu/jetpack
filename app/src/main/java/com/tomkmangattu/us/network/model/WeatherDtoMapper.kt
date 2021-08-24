package com.tomkmangattu.us.network.model

import com.tomkmangattu.us.domain.model.WeatherData
import com.tomkmangattu.us.domain.util.DomainMapper

class WeatherDtoMapper : DomainMapper<WeatherDto, WeatherData> {
    override fun mapToDomainModel(model: WeatherDto): WeatherData {
        return WeatherData(
            lon = model.coord?.lon,
            lat = model.coord?.lat,
            condition = model.weather?.get(0)?.condition,
            description = model.weather?.get(0)?.description,
            maxTemp = model.mainData?.tempMax,
            temperature = model.mainData?.temp,
            minTemp = model.mainData?.tempMin,
            humidity = model.mainData?.humidity,
            visibility = model.visibility,
            speed = model.wind?.speed
        )
    }

    override fun mapFromDomainModel(domainModel: WeatherData): WeatherDto {
        return WeatherDto()
    }
}