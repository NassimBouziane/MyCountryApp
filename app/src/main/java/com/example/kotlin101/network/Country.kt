package com.example.kotlin101.network

// class Country : ArrayList<CountryItem>()
data class Country(
    val name: String,
    val region: String,
    val languages: List<Language>,
    val currencies: List<Currency>?,
    val timezones: List<String>,
    val flag: String,
)
data class Currency(
    val name: String,
)
data class Language (
    val name: String,
)
