package com.example.kotlin101

import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getOrNull
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow


class MainViewModel : ViewModel()  {
    data class country (       val name: String? = null,
                               var region: String? = null,
                               var tld: String? = null,
                               var cca2: String? = null,
                               var ccn3: String? = null,
                               var cca3: String? = null,
                               var cioc: String? = null,
                               var independent: String? = null,
                               var status:String? = null,
                               var unMember: String? = null,
                               var currencies:String? = null,
                               var idd: String? = null,
                               var capital:String ? = null,
                               var altSpellings:String? = null,
                               var subregion:String? = null,
                               var languages:String? = null,
                               var translations:String? = null,
                               var latlng :String? = null,
                               var landlocked:String? = null,
                               var area:String? = null,
                               var flag:String? = null,
                               var flags:String? = null,
                               var demonyms:String? = null,
                               var fra:String? = null)





      fun test() {
          /*val string = Fuel.get("https://restcountries.com/v3.1/all").body!!.toString()
         println(string) */
          //println("test")
          println("test")


           Thread {
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
                          println(data)
                         val gson = Gson()
                         val response = gson.fromJson(data, country::class.java)
                         println(response)
                         //val responseState = MutableStateFlow(emptyArray<country>())
                         //responseState.value = response
                         //println(responseState.value)


                     }
                }


           }.start()



     }
}


