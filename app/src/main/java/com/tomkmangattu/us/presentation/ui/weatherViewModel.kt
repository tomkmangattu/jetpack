package com.tomkmangattu.us.presentation.ui


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomkmangattu.us.domain.model.WeatherData
import com.tomkmangattu.us.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    @Named("appid") private val appid: String,
) : ViewModel() {

    var weatherData = mutableStateOf(WeatherData())
    var loading = mutableStateOf(false)
    var cityName = mutableStateOf("london")

    init {
        getWeatherData()
    }

    fun updateCityName(cityName : String){
        this.cityName.value = cityName
    }

    fun getWeatherData(){
        loading.value = true
        viewModelScope.launch {
           weatherData.value = weatherRepository.search(appid = appid, cityName = cityName.value)
            loading.value = false
        }

    }
}