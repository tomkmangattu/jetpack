package com.tomkmangattu.us.network

import com.tomkmangattu.us.network.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun search(
        @Query("appid") authId : String,
        @Query("q") city: String,
    ):WeatherDto


}