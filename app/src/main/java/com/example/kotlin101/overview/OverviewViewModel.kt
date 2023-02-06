package com.example.kotlin101.overview

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.kotlin101.network.CountryApi
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin101.network.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel: ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    /**
     * Call getAllCountry() on init so we can display status immediately.
     */
    init {
        getAllCountry()
    }

    /**
     * Gets Countries  information from the country API Retrofit service and updates the
     * [Countries] [List] [LiveData].
     */

    private fun getAllCountry() {
        viewModelScope.launch {
            try {
                val listResult = CountryApi.retrofitService.getCountry()
                println("Success list of country retrieved")
                println("Success: $listResult")
                _status.value = "Success: $listResult list of country retrieved"
            } catch (e: Exception) {
                println("Failure: ${e.message}")
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}