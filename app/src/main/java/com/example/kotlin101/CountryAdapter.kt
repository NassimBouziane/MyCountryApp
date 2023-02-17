package com.example.kotlin101

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter (private val countriesList : Countries):RecyclerView.Adapter<CountryAdapter.FoodViewHolder>() {
    class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
    // This is where we now collect our values from
        val country_name : TextView = itemView.findViewById(R.id.country_name)
        val country_continent : TextView = itemView.findViewById(R.id.country_continent)
        val country_flag : ImageView = itemView.findViewById(R.id.country_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(R.layout.recyclerView, parent,false)
        return FoodViewHolder(viewLayout)
    }

    override fun getItemCount() = countriesList.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val CurrentCountry = countriesList[position]
        holder.country_name.text = CurrentCountry.name
        holder.country_continent.text = CurrentCountry.region
        // holder.country_flag.setImageResource(CurrentCountry.flag)
        Picasso.get().load(countriesList[position].flag).into(holder.country_flag)
    }

}