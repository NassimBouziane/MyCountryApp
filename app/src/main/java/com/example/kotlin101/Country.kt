package com.example.kotlin101

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class Countries : ArrayList<Country>()

data class Country(
    val name: String,
    val region: String,
    val languages: List<Language>,
    val currencies: List<Currency>?,
    val timezones: List<String>,
    val flag: String,
)/*{
    class Deserializer: ResponseDeserializable<Array<Country>> {
        override fun deserialize(content: String): Array<Country>? = Gson().fromJson(content, Array<Country>::class.java)
    }
}*/

data class Currency(
    val name: String,
)/*{
    class Deserializer: ResponseDeserializable<Array<Currency>> {
        override fun deserialize(content: String): Array<Currency>? = Gson().fromJson(content, Array<Currency>::class.java)
    }
}*/

data class Language (
    val name: String,
)/*{
    class Deserializer: ResponseDeserializable<Array<Language>> {
        override fun deserialize(content: String): Array<Language>? = Gson().fromJson(content, Array<Language>::class.java)
    }
}*/
