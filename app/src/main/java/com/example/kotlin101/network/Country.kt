package com.example.kotlin101.network

// class Country : ArrayList<CountryItem>()

data class CountryItem(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val currencies: List<Currency>,
    val demonym: String,
    val flag: String,
    val flags: Flags,
    val gini: Double,
    val independent: Boolean,
    val languages: List<Language>,
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val regionalBlocs: List<RegionalBloc>,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
    val translations: Translations
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CountryItem

        if ((altSpellings ?: emptyList()) != other.altSpellings) return false
        if ((area ?: "") != other.area) return false
        if ((borders ?: emptyList()) != other.borders) return false
        if ((callingCodes ?: emptyList()) != other.callingCodes) return false
        if ((capital ?: "") != other.capital) return false
        if ((cioc ?: "") != other.cioc) return false
        if ((demonym ?: "") != other.demonym) return false
        if ((flag ?: "") != other.flag) return false
        if ((gini ?: "") != other.gini) return false
        if ((independent ?: "") != other.independent) return false
        if ((latlng ?: emptyList()) != other.latlng) return false
        if ((name ?: "") != other.name) return false
        if ((nativeName ?: "") != other.nativeName) return false
        if ((numericCode ?: "")!= other.numericCode) return false
        if ((population ?: "") != other.population) return false
        if ((region ?: "") != other.region) return false
        if ((subregion ?: "") != other.subregion) return false
        if ((timezones ?: emptyList()) != other.timezones) return false
        if ((topLevelDomain ?: emptyList()) != other.topLevelDomain) return false

        return true
    }

    override fun hashCode(): Int {
        var result = alpha2Code.hashCode()
        result = 31 * result + alpha3Code.hashCode()
        result = 31 * result + altSpellings.hashCode()
        result = 31 * result + area.hashCode()
        result = 31 * result + borders.hashCode()
        result = 31 * result + callingCodes.hashCode()
        result = 31 * result + capital.hashCode()
        result = 31 * result + cioc.hashCode()
        result = 31 * result + currencies.hashCode()
        result = 31 * result + demonym.hashCode()
        result = 31 * result + flag.hashCode()
        result = 31 * result + flags.hashCode()
        result = 31 * result + gini.hashCode()
        result = 31 * result + independent.hashCode()
        result = 31 * result + languages.hashCode()
        result = 31 * result + latlng.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + nativeName.hashCode()
        result = 31 * result + numericCode.hashCode()
        result = 31 * result + population
        result = 31 * result + region.hashCode()
        result = 31 * result + regionalBlocs.hashCode()
        result = 31 * result + subregion.hashCode()
        result = 31 * result + timezones.hashCode()
        result = 31 * result + topLevelDomain.hashCode()
        result = 31 * result + translations.hashCode()
        return result
    }
}

data class Currency(
    val code: String,
    val name: String,
    val symbol: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Currency
        if ((code ?: "") != other.code) return false
        if ((name ?: "") != other.name) return false
        if ((symbol ?: "") != other.symbol) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + symbol.hashCode()
        return result
    }
}

data class Flags (
    val png: String,
    val svg: String
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Flags
        if ((png ?: "") != other.png) return false
        if ((svg ?: "") != other.svg) return false

        return true
    }

    override fun hashCode(): Int {
        var result = png.hashCode()
        result = 31 * result + svg.hashCode()
        return result
    }

}

data class Language (
    val iso639_1: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Language
        if ((iso639_1 ?: "") != other.iso639_1) return false
        if ((iso639_2 ?: "") != other.iso639_2) return false
        if ((name ?: "") != other.name) return false
        if ((nativeName ?: "") != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = iso639_1.hashCode()
        result = 31 * result + iso639_2.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + nativeName.hashCode()
        return result
    }
}

data class RegionalBloc (
    val acronym: String,
    val name: String,
    val otherAcronyms: List<String>,
    val otherNames: List<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RegionalBloc

        if ((acronym ?: "") != other.acronym) return false
        if ((name ?: "") != other.name) return false
        if ((otherAcronyms ?: emptyList()) != other.otherAcronyms) return false
        if ((otherNames ?: emptyList()) != other.otherNames) return false

        return true
    }

    override fun hashCode(): Int {
        var result = acronym.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + otherAcronyms.hashCode()
        result = 31 * result + otherNames.hashCode()
        return result
    }
}

data class Translations (
    val br: String,
    val de: String,
    val es: String,
    val fa: String,
    val fr: String,
    val hr: String,
    val hu: String,
    val it: String,
    val ja: String,
    val nl: String,
    val pt: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Translations

        if ((br ?: "") != other.br) return false
        if ((de ?: "") != other.de) return false
        if ((es ?: "") != other.es) return false
        if ((fa ?: "") != other.fa) return false
        if ((fr ?: "") != other.fr) return false
        if ((hr ?: "") != other.hr) return false
        if ((hu ?: "") != other.hu) return false
        if ((it ?: "") != other.it) return false
        if ((ja ?: "") != other.ja) return false
        if ((nl ?: "") != other.nl) return false
        if ((pt ?: "") != other.pt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = br.hashCode()
        result = 31 * result + de.hashCode()
        result = 31 * result + es.hashCode()
        result = 31 * result + fa.hashCode()
        result = 31 * result + fr.hashCode()
        result = 31 * result + hr.hashCode()
        result = 31 * result + hu.hashCode()
        result = 31 * result + it.hashCode()
        result = 31 * result + ja.hashCode()
        result = 31 * result + nl.hashCode()
        result = 31 * result + pt.hashCode()
        return result
    }
}