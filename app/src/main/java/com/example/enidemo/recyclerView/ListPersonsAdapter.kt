package com.example.enidemo.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.enidemo.Person
import com.example.enidemo.databinding.ItemPersonBinding

class ListPersonsAdapter : ListAdapter<Person, ListPersonsAdapter.ViewHolder>(PersonDiffCallback()){

    // créer une ligne (le style de la ligne)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    // attacher une donnée à une cellule
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // récupération de la personne d'une liste de données
        val person = getItem(position)
        // connexion de la personne récupérée dans la ligne
        holder.bind(person)
    }

    // class interne qui hérite de RecyclerView.ViewHolder pour définir la cellule/ligne (=binding) dans le recyclerView
    class ViewHolder (val binding : ItemPersonBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Person) {
            // connexion person-cellule
            binding.person = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPersonBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}