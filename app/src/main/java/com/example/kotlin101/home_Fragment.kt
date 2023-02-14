package com.example.kotlin101

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin101.Countries.Countries
import kotlinx.coroutines.*
import androidx.appcompat.widget.SearchView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var searchView: SearchView


/**
 * A simple [Fragment] subclass.
 * Use the [home_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class home_Fragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: RecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    // private lateinit var mList: Countries
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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // testing send with data with bundle
        val mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        //runBlocking {  mainActivityViewModel.fetchCountries() }






        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.Default) { if(mainActivityViewModel.responseState.value.size == 0){mainActivityViewModel.fetchCountries()} }
            recyclerView = view.findViewById(R.id.reclyclerView)
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            // recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.setHasFixedSize(true)


            adapter = RecyclerAdapter(mainActivityViewModel.responseState.value)
            recyclerView.adapter = adapter

            searchView = view.findViewById(R.id.searchView)
            searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if(query != null) {
                        val bundle = bundleOf("query" to query )
                        val filteredList = Countries()
                        for (i in mainActivityViewModel.responseState.value) {
                            if(i.name.common.lowercase().contains(query.lowercase()))
                                filteredList.add(i)
                        }
                        adapter = RecyclerAdapter(filteredList)
                        recyclerView.adapter = adapter
                        onclick_fragment.query = query

                    }

                    return true
                }
            })
        }
            return view
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment home_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
