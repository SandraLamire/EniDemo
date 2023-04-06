package com.example.enidemo.tplieu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityTpLieuBinding


class TpLieuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val atlb = DataBindingUtil.setContentView<ActivityTpLieuBinding>(this, R.layout.activity_tp_lieu);

        // Instancier un adapter
        val adapter = ListLieuAdapter()

        // Liaison du lieu view avec mon adapteur
        atlb.rvLieux.adapter = adapter

        // Une liste de 3 lieux
        val listLieux = mutableListOf(
            Lieu("Chez Raphael", "Puit de la mort qui tue"),
            Lieu("Chez Arthur", "Manoir, attention on est chez un Noble"),
            Lieu("Chez Bastien", "La glissade"))

        // Envoyer ces 3 lieux dans la view
        adapter.submitList(listLieux)
    }
}