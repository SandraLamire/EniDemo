package com.example.enidemo.counter

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    // compteur observable
    var counter = MutableLiveData<Int>()

    // constructeur
    init{
        counter.value = 0
    }

    // modifier la valeur du compteur
    fun addCounter(){
        counter.value = (counter.value)?.plus(1)
        println("Test")
    }

    fun onClickAddCounter(view: View) {
        addCounter()
    }
}