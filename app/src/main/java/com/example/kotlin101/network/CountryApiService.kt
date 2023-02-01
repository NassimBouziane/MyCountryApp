package com.example.kotlin101.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://restcountries.com/v3.1/"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getCountry] method
 */
interface CountryApiService {
    /**
    * Returns a [List] of [Countries] and this method can be called from a Coroutine.
    * The @GET annotation indicates that the "all" endpoint will be requested with the GET
    * HTTP method
    */
    @GET("all")
    suspend fun getCountry(): List<Countries>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object CountryApi {
    val retrofitService : CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)
    }
}