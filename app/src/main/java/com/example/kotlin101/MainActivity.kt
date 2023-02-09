package com.example.kotlin101

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.core.view.isEmpty
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin101.Countries.Name
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

 //getting the viewmodel things here
    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_main)
     val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
     navController = navHostFragment.navController
     //val mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
     //mainActivityViewModel.test()
     setupActionBarWithNavController(navController)


 }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)



    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}