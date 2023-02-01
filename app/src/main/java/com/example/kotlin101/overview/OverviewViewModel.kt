package com.example.kotlin101.overview

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.kotlin101.network.CountryApi
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData



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
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [Countries] [List] [LiveData].
     */
    private fun getAllCountry() {
        viewModelScope.launch {
            try {
                val listResult = CountryApi.retrofitService.getCountry()
                _status.value = "Success: ${listResult.size} Mars photos retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}