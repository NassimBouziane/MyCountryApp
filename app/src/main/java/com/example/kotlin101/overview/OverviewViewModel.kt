package com.example.kotlin101.overview

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.kotlin101.network.CountryApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.kotlin101.network.Country
import kotlinx.coroutines.flow.asStateFlow


class MyViewModel: ViewModel() {
    private val _country = MutableStateFlow<List<Country>>(emptyList())
    val country = _country.asStateFlow()

    init {
        getAllCountry()
    }

     /* Gets Countries  information from the country API Retrofit service and updates the
      [Countries] [List] [LiveData].*/
    private fun getAllCountry() {
        viewModelScope.launch {
            try {
                val requestResult = CountryApi.retrofitService.getCountry()
                _country.value = requestResult
                // println("Success list of country retrieved")
                println("Success: $requestResult")
                // _status.value = "Success: $requestResult list of country retrieved"
            } catch (e: Exception) {
                println("Failure: ${e.message}")
                // _status.value = "Failure: ${e.message}"
            }
        }
    }
}
