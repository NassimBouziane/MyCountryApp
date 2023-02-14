package com.example.kotlin101

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin101.Countries.Countries
import com.squareup.picasso.Picasso



//private var continents: List<String>, private var image:List<Int>
class RecyclerAdapter(private var country: Countries) :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val country_name: TextView = itemView.findViewById(R.id.country_name)
        val country_contient: TextView = itemView.findViewById(R.id.country_continent)
        val country_image: ImageView = itemView.findViewById(R.id.country_image)


        init {

            itemView.setOnClickListener{
                //val country_selected_name = country[position].name.common
                //val country_selected_contient = country[position].continents.toString()
                //val country_selected_languages = country[position].languages.toString()
                //val country_selected_currencies = country[position].currencies.toString()
                //val country_selected_timezone = country[position].timezones.toString()



                // val bundle = bundleOf(Pair("Country_name", country_selected_name), Pair("Country_Continent", country_selected_contient)
                //,Pair("Country_languages", test.toString()),Pair("Country_currencies", country_selected_currencies),
                //  Pair("Country_timezone", country_selected_timezone)
                //)
                val index = position
                val bundle = bundleOf("index" to index )


                //changez de fragment et mettre toutes les infos en bundle

                val navController: NavController = itemView.findNavController()
                navController.navigate(R.id.action_home_Fragment_to_onclick_fragment, bundle)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return country.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        // idée : Ajouter une barre de recherche ou on affiche que la liste filtré
        country.sortBy { it.name.common.toString() }
        country.sortBy { it.continents.toString() }
        holder.country_name.text = country[position].name.common.toString()
        holder.country_contient.text = country[position].continents.first().toString()
        Picasso.get().load(country[position].flags.png).into(holder.country_image)
    }

}
