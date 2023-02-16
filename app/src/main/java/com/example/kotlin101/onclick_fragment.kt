package com.example.kotlin101

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.kotlin101.Countries.Countries
import com.example.kotlin101.Countries.CountriesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_onclick_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import kotlin.reflect.typeOf
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.Instant
import java.time.ZoneId
import kotlin.math.ln

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [onclick_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class onclick_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onclick_fragment, container, false)
        //val button = view.findViewById<Button>(R.id.button2)

        val languages = view.findViewById<TextView>(R.id.languages)
        val name = view.findViewById<TextView>(R.id.name)
        val continent = view.findViewById<TextView>(R.id.continent)
        val currency = view.findViewById<TextView>(R.id.currency)
        val image = view.findViewById<ImageView>(R.id.image)
        val timezone = view.findViewById<TextView>(R.id.timezone)
        val scrollview = view.findViewById<ScrollView>(R.id.scrollview)
        val button = view.findViewById<Button>(R.id.buttontimezone)


        val viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        button.setOnClickListener{
            timezone.visibility = View.VISIBLE
            button.visibility = View.GONE
        }




        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.Default) {if(viewmodel.responseState.value.size == 0){viewmodel.fetchCountries()}}
            var index :Int = arguments?.get("index") as Int
            var country = viewmodel.responseState.value
            country.sortBy { it.name.common.toString() }
            country.sortBy { it.continents.toString() }

            if (query != null){
            val filteredList = Countries()
            for (i in viewmodel.responseState.value) {
                if(i.name.common.lowercase().contains(query!!.lowercase()))
                    filteredList.add(i)
            }
            data(filteredList[index])
                (activity as AppCompatActivity).supportActionBar?.title = filteredList[index].name.common

                query = null
            }
            else{
                data(country[index])
                (activity as AppCompatActivity).supportActionBar?.title = country[index].name.common

            }



        }
        return  view


        // Titre dans le Systeme UI qui change par rapport a l'argumetn envoyé dans le bundle


    }
    @SuppressLint("SetTextI18n")
    fun data(country : CountriesItem){

        if(country.languages != null){
        languages.text = "Langue: " + country.languages.name}
        else{
            languages.text = "Langue: non spécifiée"
        }
        name.text = country.name.common
        continent.text = country.continents[0]
        if(country.currencies != null){
            currency.text = "Devise locale: " + country.currencies.currency?.name + " " +country.currencies.currency?.symbol

        }
        else{
            currency.text = "Devise non spécifiée"
        }
        val currentInstant = Instant.now()
        if(country.timezones.size > 1){
            buttontimezone.visibility = View.VISIBLE

            timezones(country)


        }
        else {
            timezone.visibility = View.VISIBLE
            buttontimezone.visibility = View.GONE
            val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(country.timezones[0]))
            val formatter = DateTimeFormatter.ofPattern("HH:mm")
            val formatted = current.format(formatter)

            timezone.text = "Heure Locale: " + formatted
        }
        scrollview.post{
            scrollview.fullScroll(View.FOCUS_UP)
        }
        Picasso.get().load(country.flags.png).into(image)




    }
fun timezones(country: CountriesItem){
    val currentInstant = Instant.now()
    for(timezones in country.timezones){
        val formatter = DateTimeFormatter.ofPattern("HH:mm")


        when(country.name.common){
            "France" -> {
                val index = country.timezones.indexOf(timezones)
                val city = cities_france.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")
            }

            "United States" -> {

                val index = country.timezones.indexOf(timezones)
                val city = cities_usa.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Russia" ->{

                val index = country.timezones.indexOf(timezones)
                val city = cities_russia.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Antarctica" -> {
                val index = country.timezones.indexOf(timezones)
                val city = cities_antartica.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "United Kingdom" ->{
                val index = country.timezones.indexOf(timezones)
                val city = cities_england.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Australia" ->{
                val index = country.timezones.indexOf(timezones)
                val city = cities_australia.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Canada" ->{
                val index = country.timezones.indexOf(timezones)
                val city = cities_canada.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")
            }
            "Denmark" -> {
                val index = country.timezones.indexOf(timezones)
                val city = cities_denmark.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "New Zealand" -> {
                val index = country.timezones.indexOf(timezones)
                val city = cities_NewZealand.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Brazil" -> {
                val index = country.timezones.indexOf(timezones)
                val city = cities_Brazil.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Mexico" ->{
                val index = country.timezones.indexOf(timezones)
                val city = cities_Mexico.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }
            "Indonesia" ->{
                val index = country.timezones.indexOf(timezones)
                val city = cities_Indonesia.getOrNull(index) ?: "Ville introuvable"
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones $city : $formatted \n")

            }



            else -> {
                val current = LocalDateTime.ofInstant(currentInstant, ZoneId.of(timezones))
                val formatted = current.format(formatter)

                timezone.append("$timezones : $formatted \n")

            }

        }



    }
    scrollview.visibility = View.VISIBLE

}

    companion object {
        var query: String? = null
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment onclick_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            onclick_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
val cities_france = listOf(
    "Polynésie française",
    "Îles Marquises, Polynésie française",
    "Îles Gambier, Polynésie française",
    "Ile Clipperton",
    "Guadeloupe, Martinique",
    "Guyane, Saint pierre-Et-Miquelon",
    "Metropole (Paris)",
    "Heure d'été ",
    "Mayonette, Canal du mozambique",
    "La Réunion",
    "Île Saint-Paul, Île Amsterdam, Îles Kerguelen",
    "Terre-Adélie",
    "Nouvelle-Calédonie",
    "Wallis-et-Futuna"
)
val cities_usa = listOf(
"Baker Island",
           "Pago Pago",
           "Honolulu",
            "Anchorage",
            "Los Angeles",
            "Denver",
            "Chicago",
            "New York",
            "San Juan",
    "Guam, Iles Mariannes du nord",
            "Wake"
)
val cities_russia = listOf(
    "Moscou, Saint-Pétersbourg", "Samara, Izhevsk ", " Omsk ",
    "Krasnoïarsk ",  "Irkoutsk, Oulan-Oude", "Iakoutsk ", "Vladivostok, Khabarovsk ",  "Magadan ",  "Anadyr ",

)
val cities_antartica= listOf(
    "Etat-unis","Royaume-uni","Zustralie","Russie","Australie","Australie","France","Italie"
)
val cities_england = listOf(" île Pitcairn",
    " Les îles Caïmans , les Îles Turques-et-Caïques",
    "Anguilla, Bermudes, Îles Vierges britanniques, Montserrat",
    " Les îles Falkland",
    "Géorgie du Sud-et-les Îles Sandwich du Sud",
    "Territoire métropolitain de la Grande-Bretagne",
    " Gibraltar",
    "Akrotiri et Dhekelia",
    "Territoire britannique de l'océan Indien")

val cities_australia = listOf(" Îles Heard-et-MacDonald",
    "Îles Cocos",
    " Île Christmas (Australie)",
    "Ouest Australien",
    "Australie-Méridionale et Territoire du Nord",
    " Queensland, Nouvelle-Galles du Sud, Territoire de la capitale australienne, Victoria, Tasmanie",
    " Île Lord Howe",
    "Norfolk (comté)")
val cities_canada = listOf("Tungsten, la mine de Cantung dans les Territoires du Nord-Ouest, Yukon",
    "Alberta, quelques parties Est de la Colombie-Britannique, la plus grande part des Territoires du Nord-Ouest, Nunavut, Lloydminster et aux alentours, Saskatchewan",
    "Manitoba, Nunavut, Ontario, Saskatchewan sauf de Lloydminster",
    " Nunavut east of 85°W and entire Southampton Island, Ontario est de la 90°W  et quelques parties Est du Québec, Québec",
    " Labrador (tout le Labrador sauf l'extrême sud), Nouveau-Brunswick, Nouvelle-Écosse, Île-du-Prince-Édouard, partie Est du Québec",
    " Labrador (Partie sud), Terre-Neuve")

val cities_denmark = listOf("Base aérienne de Thulé au Groenland",
    "La plupart du Groenland, y compris les côtes Sud et Ouest habitées",
    " Ittoqqortoormiit et les alentours du comté de Tunu",
    " La station météorologique de Danmarkshavn",
    "Danemark métropolitain",)
val cities_NewZealand = listOf(" Niue",
    " Les iles Cook",
    "La plupart de la Nouvelle-Zélande",
    "Îles Chatham",
    "Tokelau")
val cities_Brazil = listOf(" Acre et Amazonas du sud-ouest",
    "  Amazonas, Mato Grosso, Mato Grosso do Sul, Rondônia, Roraima, Acre",
    " Sudeste, Sud, Nordeste , Goias, District fédéral, Tocantins, Pará, Amapa",
    "Fernando de Noronha, Trindade et Martin Vaz, Atoll das Rocas, Saint-Pierre et Saint-Paul")
val cities_Mexico = listOf(" (Zone 3 ou Zone Nord-Ouest) — Basse-Californie",
    " (Zone 2 ou Zone Pacifique ) — Basse-Californie du Sud, Chihuahua, Nayarit, Sinaloa et Sonora",
    "(Zone 1 ou Zone Pacifique ) — La majeure partie du Mexique.",
    " (Zone 1 ou Zone Sud-Est) — Quintana Roo")
val cities_Indonesia = listOf("(Western Indonesian Standard Time) — Îles de Sumatra et de Java, provinces du Kalimantan occidental et du Kalimantan central",
    "(Central Indonesian Standard Time) — Célèbes, petites îles de la Sonde (dont Bali), provinces du Kalimantan oriental et du Kalimantan du Sud",
    "(Eastern Indonesian Standard Time) — Moluques et Nouvelle-Guinée occidentale")