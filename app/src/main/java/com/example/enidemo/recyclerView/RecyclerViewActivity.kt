package com.example.enidemo.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // récupération et chargement du xml/vue en version databinding
        val arvb = DataBindingUtil.setContentView<ActivityRecyclerViewBinding>(this, R.layout.activity_recycler_view)

        // liaison du recyclerView avec l'adapter
        val adapter = ListPersonsAdapter()
        arvb.rvPersons.adapter = adapter

        //
        val listPerson = mutableListOf(Person("Arthur"), Person("Raphael"), Person("Carole"))
        adapter.submitList(listPerson)

    }
}