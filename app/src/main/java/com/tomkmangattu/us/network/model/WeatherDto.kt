package com.tomkmangattu.us.network.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("coord")
    val coord: Coordinates? = null,

    @SerializedName("weather")
    val weather: List<Main>? = null,

    @SerializedName("main")
    val mainData: MainData? = null,

    @SerializedName("visibility")
    val visibility: String? = null,

    @SerializedName("wind")
    val wind: Wind? = null,
)

data class Wind (
    @SerializedName("speed")
    val speed: String? = null,
)


data class MainData(
    @SerializedName("temp")
    val temp: String? = null,

    @SerializedName("temp_min")
    val tempMin: String? = null,

    @SerializedName("temp_max")
    val tempMax: String? = null,

    @SerializedName("pressure")
    val pressure: String? = null,

    @SerializedName("humidity")
    val humidity: String? = null,
)


data class Main(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("main")
    val condition: String? = null,

    @SerializedName("description")
    val description: String? = null,

)

data class Coordinates(

    @SerializedName("lon")
    val lon: String? = null,

    @SerializedName("lat")
    val lat: String? = null,
)