package com.example.enidemo.tplieu

import androidx.recyclerview.widget.DiffUtil

class LieuDiffCallback : DiffUtil.ItemCallback<Lieu>() {

    override fun areItemsTheSame(oldItem: Lieu, newItem: Lieu): Boolean {
        return oldItem.nom == newItem.nom
    }

    override fun areContentsTheSame(oldItem: Lieu, newItem: Lieu): Boolean {
        return oldItem.equals(newItem)
    }
}