package com.example.enidemo.average

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityAverageBinding

class AverageActivity : AppCompatActivity() {

    lateinit var averageViewModel: AverageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // récupérer la vue en activant le dataBinding
        val activityAverageBinding = DataBindingUtil.setContentView<ActivityAverageBinding>(this,R.layout.activity_average)

        // instancier par défaut le view model
        averageViewModel = AverageViewModel()
        // mettre à jour le view model dans la vue
        activityAverageBinding.averageViewModel = averageViewModel

        // écouter le changement sur la moyenne
        averageViewModel.averageNote.observe(this, Observer{
            // rafraichir le viewModel dans la vue
            activityAverageBinding.averageViewModel = averageViewModel
        })

        // afficher Titre : Calculateur de moyennes
        averageViewModel.afficherTitre(this)
    }

}