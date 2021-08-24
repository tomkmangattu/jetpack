package com.tomkmangattu.us.di

import com.google.gson.GsonBuilder
import com.tomkmangattu.us.network.WeatherService
import com.tomkmangattu.us.network.model.WeatherDtoMapper
import com.tomkmangattu.us.util.APPID
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun providesRecipeMapper(): WeatherDtoMapper{
        return WeatherDtoMapper()
    }

    @Singleton
    @Provides
    fun providesWeatherService(): WeatherService{
        return Retrofit
            .Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(WeatherService:: class.java)
    }

    @Singleton
    @Provides
    @Named("appid")
    fun providesAuthId(): String{
        return APPID
    }



}