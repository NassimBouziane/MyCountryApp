

package com.example.kotlin101

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin101.Countries.Countries
import com.example.kotlin101.Countries.Name
import com.squareup.picasso.Picasso

//private var continents: List<String>, private var image:List<Int>
class RecyclerAdapter(private var country: Countries) :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val country_name: TextView = itemView.findViewById(R.id.country_name)
        val country_contient: TextView = itemView.findViewById(R.id.country_continent)
        val country_image: ImageView = itemView.findViewById(R.id.country_image)

        init {
            itemView.setOnClickListener{
                println("teststest")
                //changez de fragment et mettre toutes les infos en bundle
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

        holder.country_name.text = country[position].name.common.toString()
        holder.country_contient.text = country[position].continents.first().toString()
        //holder.country_image.setImageResource(image[position])
        Picasso.get().load(country[position].flags.png).into(holder.country_image)
    }

}