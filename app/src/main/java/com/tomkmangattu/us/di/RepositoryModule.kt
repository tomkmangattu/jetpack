package com.tomkmangattu.us.di

import com.tomkmangattu.us.network.WeatherService
import com.tomkmangattu.us.network.model.WeatherDtoMapper
import com.tomkmangattu.us.repository.WeatherRepository
import com.tomkmangattu.us.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherService: WeatherService,
        mapper: WeatherDtoMapper
    ) : WeatherRepository{
        return WeatherRepositoryImpl(
            weatherService = weatherService,
            mapper = mapper,
        )
    }
}