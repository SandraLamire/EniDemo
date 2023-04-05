package com.example.enidemo.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityCounterBinding
import com.example.enidemo.databinding.ActivityMainBinding

class CounterActivity : AppCompatActivity() {

    lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // récupérer la vue
        val activityCounterBinding = DataBindingUtil.setContentView<ActivityCounterBinding>(this, R.layout.activity_counter)

        // instancier par défaut le view model
        counterViewModel = CounterViewModel()
        // mettre à jour le view model dans la vue
        activityCounterBinding.counterViewModel = counterViewModel

        // écouter le changement du compteur
        counterViewModel.counter.observe(this, Observer{
            // remettre à jour le view model dans la vue quand changement de valeur du compteur
            activityCounterBinding.counterViewModel = counterViewModel
        })
    }
}
