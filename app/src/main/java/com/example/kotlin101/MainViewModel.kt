package com.example.kotlin101

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin101.Countries.Countries
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getOrNull
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow


class MainViewModel : ViewModel()  {
    val responseState = MutableStateFlow(Countries())
init {
    viewModelScope.launch { fetchCountries() }

}



      suspend fun fetchCountries() {

          withContext(Dispatchers.Default) {
              // Do network action in this function

              val (request, response, result) = "https://restcountries.com/v3.1/all"
                  .httpGet()
                  .responseString()

              when (result) {
                  is Result.Failure -> {
                      val ex = result.getOrNull()
                      println(ex)
                  }
                  is Result.Success -> {
                      val data = result.get()
                      //println(data)
                      val gson = Gson()
                      val response = gson.fromJson(data, Countries::class.java)
                      //println(response)

                      //for(country in response)
                      //println(country.demonyms)

                      responseState.value = response
                      //println(responseState.value)


                  }
              }
          }






     }
}


