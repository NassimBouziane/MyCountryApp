package com.example.kotlin101

import androidx.lifecycle.ViewModel
import com.example.kotlin101.Countries.Countries
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getOrNull
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import org.json.JSONObject


class MainViewModel : ViewModel()  {
    val responseState = MutableStateFlow(Countries())




      suspend fun fetchCountries() {
          /*val string = Fuel.get("https://restcountries.com/v3.1/all").body!!.toString()
         println(string) */
          //println("test")

          withContext(Dispatchers.Default) {
              // Do network action in this function
              /*val jsonStr = URL("https://restcountries.com/v3.1/all").readText()
                println(jsonStr)*/
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


