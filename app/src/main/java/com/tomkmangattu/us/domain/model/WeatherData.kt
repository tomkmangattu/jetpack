package com.tomkmangattu.us.domain.model


// api.openweathermap.org/data/2.5/weather


data class WeatherData (
    val lon : String? = null,
    val lat : String? = null,
    val condition: String? = null,
    val description: String? = null,
    val temperature: String? = null,
    val maxTemp: String? = null,
    val minTemp: String? = null,
    val humidity: String? = null,
    val visibility: String? = null,
    val speed: String? = null,
)