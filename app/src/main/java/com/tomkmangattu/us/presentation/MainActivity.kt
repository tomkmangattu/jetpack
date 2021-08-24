package com.tomkmangattu.us.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.tomkmangattu.us.presentation.component.WeatherWidget
import com.tomkmangattu.us.presentation.ui.WeatherViewModel
import com.tomkmangattu.us.ui.theme.UsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsTheme {
                HomeScreen(
                    viewModel = viewModel,
                )
            }
        }
    }
}

@Composable
fun HomeScreen(
    viewModel: WeatherViewModel
){
    val loading = viewModel.loading.value
    val weatherData = viewModel.weatherData.value
    val cityName = viewModel.cityName.value
    Surface(
        color = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = cityName,
                onValueChange ={
                    viewModel.updateCityName(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(12.dp),
                label = {
                    Text("Enter city name")
                },
                keyboardActions = KeyboardActions(
                    onDone = {
                        viewModel.getWeatherData()
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                ),
            )

            if (loading){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator()
                }
            }else{
                weatherData?.let {
                    WeatherWidget(weatherData = it)
                }
            }
        }
    }
}
