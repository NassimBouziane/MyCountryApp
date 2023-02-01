package com.example.kotlin101

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getFailureOrNull
import kotlinx.coroutines.runBlocking
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


class MainViewModel : ViewModel()  {


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
                          val ex = result.getFailureOrNull()
                          println(ex)
                     }
                     is Result.Success -> {
                          val data = result.get()
                          println(data)
                     }
                }


           }.start()



     }
}


