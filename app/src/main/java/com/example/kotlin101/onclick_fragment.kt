package com.example.kotlin101

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kotlin101.Countries.Countries
import com.example.kotlin101.Countries.CountriesItem
import com.example.kotlin101.Countries.Languages
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_onclick_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import kotlin.reflect.typeOf

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


        val viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (viewmodel?.responseState?.value?.size == 0){

        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.Default) { viewmodel.fetchCountries()}
            var index :Int = arguments?.get("index") as Int
            var country = viewmodel.responseState.value
            country.sortBy { it.name.common.toString() }
            country.sortBy { it.continents.toString() }
            data(country[index])

            (activity as AppCompatActivity).supportActionBar?.title = country[index].name.common

        }}



        // Titre dans le Systeme UI qui change par rapport a l'argumetn envoyé dans le bundle



        /*button.setOnClickListener{
            findNavController().navigate(R.id.action_onclick_fragment_to_home_Fragment)

        }*/

        return  view

    }
    fun data(country : CountriesItem){
        languages.text = country.languages.name
        name.text = country.name.common
        continent.text = country.continents[0].toString()
        currency.text = country.currencies.currency?.name + " " +country.currencies.currency?.symbol



    }

    companion object {
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