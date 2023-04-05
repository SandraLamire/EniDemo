package com.example.enidemo.average

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enidemo.R

class AverageViewModel: ViewModel() {

    // tableau qui va récupérer les notes saisies
    private val notes = arrayListOf<Float>()

    // objet écoutable qui contient un Float
    var averageNote = MutableLiveData(0.0f)
    // ou lateinit var averageNote : MutableLiveData<Float>

    @SuppressLint("SetTextI18n")
    fun afficherTitre(view: AverageActivity) {
        // récupérer un élément de la vue
        val txtView = view.findViewById<TextView>(R.id.tv_example)
        // modifier le texte
        txtView.text = "Calculateur de moyennes"
    }

    @SuppressLint("SetTextI18n")
    fun onClickButtonAdd(view: View) {
        // récupérer l'activité du bouton
        val activity = view.context as Activity

        // récupérer le champ "edt_note"
        val editTextNote = activity.findViewById<EditText>(R.id.edt_note)
        // récupérer la valeur saisie dans ce champ
        val noteString = editTextNote.text.toString()
        // si le champ n'est pas vide
        if (noteString.isNotEmpty()) {
            // transformer la saisie en float
            val note = noteString.toFloat()
            // ajouter cette saisie au tableau de notes
            notes.add(note)
            // vider le champ de saisie
            editTextNote.text.clear()
            // afficher les saisies dans le logcat pour vérifier le remplissage du tableau
            println(notes)
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickButtonStop(view: View) {
            // récupérer le champ "Moyenne générale" = inutile avec viewModel
            // val editTextAverage = (view.getContext() as Activity).findViewById<TextView>(R.id.txt_average)

            // faire la moyenne des notes du tableau
            averageNote.value = notes.average().toFloat()

            // modifier la valeur du champ "Moyenne générale" = pas nécessaire avec l'observer
            // editTextAverage.text = "Moyenne générale : %.2f".format(average)

            // vider le tableau de notes
            notes.clear()
    }
}