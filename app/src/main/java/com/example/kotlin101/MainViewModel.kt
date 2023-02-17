package com.example.kotlin101

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import android.os.Bundle
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getOrNull
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel: ViewModel() {
    private val _country = MutableStateFlow<List<Country>>(emptyList())
    val country = _country.asStateFlow()

    init {
        viewModelScope.launch {
            getCountries()
        }
    }


    suspend fun getCountries() {
        withContext(Dispatchers.Default) {
            val (request, response, result) = "https://restcountries.com/v2/all"
                .httpGet()
                .responseString()
            when (result) {
                is Result.Failure -> {
                    val res = result.getOrNull()
                    println(res)
                }
                is Result.Success -> {
                    val data = result.get()
                    val gson = Gson()
                    val res = gson.fromJson(data, Countries::class.java)
                    println(res)
                    _country.value = res
                }
            }
        }

    }
}
