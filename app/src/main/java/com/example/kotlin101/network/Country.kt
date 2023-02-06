package com.example.kotlin101.network

data class Country(
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: Currencies,
    val demonyms: Demonyms,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val gini: Gini,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val translations: Translations,
    val unMember: Boolean
)

data class CapitalInfo(
    val latlng: List<Double>
)

data class Car(
    val side: String,
    val signs: List<String>
)

data class CoatOfArms(
    val png: String,
    val svg: String
)

data class Currencies(
    val PEN: PEN
)

data class Demonyms(
    val eng: Eng,
    val fra: Fra
)

data class Flags(
    val alt: String,
    val png: String,
    val svg: String
)

data class Gini(
    val `2019`: Double
)

data class Idd(
    val root: String,
    val suffixes: List<String>
)

data class Languages(
    val aym: String,
    val que: String,
    val spa: String
)

data class Maps(
    val googleMaps: String,
    val openStreetMaps: String
)

data class Name(
    val common: String,
    val nativeName: NativeName,
    val official: String
)

data class PostalCode(
    val format: String,
    val regex: String
)

data class Translations(
    val ara: Ara,
    val bre: Bre,
    val ces: Ces,
    val cym: Cym,
    val deu: Deu,
    val est: Est,
    val fin: Fin,
    val fra: FraX,
    val hrv: Hrv,
    val hun: Hun,
    val ita: Ita,
    val jpn: Jpn,
    val kor: Kor,
    val nld: Nld,
    val per: Per,
    val pol: Pol,
    val por: Por,
    val rus: Rus,
    val slk: Slk,
    val spa: Spa,
    val srp: Srp,
    val swe: Swe,
    val tur: Tur,
    val urd: Urd,
    val zho: Zho
)

data class PEN(
    val name: String,
    val symbol: String
)

data class Eng(
    val f: String,
    val m: String
)

data class Fra(
    val f: String,
    val m: String
)

data class NativeName(
    val aym: Aym,
    val que: Que,
    val spa: Spa
)

data class Aym(
    val common: String,
    val official: String
)

data class Que(
    val common: String,
    val official: String
)

data class Spa(
    val common: String,
    val official: String
)

data class Ara(
    val common: String,
    val official: String
)

data class Bre(
    val common: String,
    val official: String
)

data class Ces(
    val common: String,
    val official: String
)

data class Cym(
    val common: String,
    val official: String
)

data class Deu(
    val common: String,
    val official: String
)

data class Est(
    val common: String,
    val official: String
)

data class Fin(
    val common: String,
    val official: String
)

data class FraX(
    val common: String,
    val official: String
)

data class Hrv(
    val common: String,
    val official: String
)

data class Hun(
    val common: String,
    val official: String
)

data class Ita(
    val common: String,
    val official: String
)

data class Jpn(
    val common: String,
    val official: String
)

data class Kor(
    val common: String,
    val official: String
)

data class Nld(
    val common: String,
    val official: String
)

data class Per(
    val common: String,
    val official: String
)

data class Pol(
    val common: String,
    val official: String
)

data class Por(
    val common: String,
    val official: String
)

data class Rus(
    val common: String,
    val official: String
)

data class Slk(
    val common: String,
    val official: String
)

data class Srp(
    val common: String,
    val official: String
)

data class Swe(
    val common: String,
    val official: String
)

data class Tur(
    val common: String,
    val official: String
)

data class Urd(
    val common: String,
    val official: String
)

data class Zho(
    val common: String,
    val official: String
)