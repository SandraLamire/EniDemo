package com.example.enidemo.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.example.enidemo.Person

// ItemCallback permet de rafraichir la ligne si elle est différente de l'originale
class PersonDiffCallback : DiffUtil.ItemCallback<Person>(){

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.firstName == newItem.firstName
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.equals(newItem)
    }

}