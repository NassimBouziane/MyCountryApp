package com.example.kotlin101

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val paysName: LiveData
    init {
        val result = Repository.paysName
        paysName = Transformations.map(result) { result -> result.value }
    }
   }
}