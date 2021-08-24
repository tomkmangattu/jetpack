package com.tomkmangattu.us.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tomkmangattu.us.domain.model.WeatherData

@Composable
fun WeatherWidget(
    weatherData: WeatherData
){
    Card (
        shape = MaterialTheme.shapes.medium
            ){
        Column(
        ) {
            WeatherItems(name = "Temperature", value = weatherData.temperature)
            WeatherItems(name = "Condition", value = weatherData.condition)
            WeatherItems(name = "Description", value = weatherData.description)
            WeatherItems(name = "Humidity", value = weatherData.humidity)
            WeatherItems(name = "Wind Speed", value = weatherData.speed)
            WeatherItems(name = "Latitude", value = weatherData.lat)
            WeatherItems(name = "Longitude", value = weatherData.lon)
        }
    }
}

@Composable
fun WeatherItems(
    name: String,
    value: String?,
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = "$name:")
        Text(text = "$value")
    }
}