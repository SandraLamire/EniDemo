package com.example.enidemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MoyenneActivity : AppCompatActivity() {
    // tableau qui va récupérer les notes saisies
    private val notes = mutableListOf<Float>()
    val notesFrancais = mutableListOf<Float>()
    val notesMaths = mutableListOf<Float>()
    val notesHistoire = mutableListOf<Float>()
    val notesBiologie = mutableListOf<Float>()


    @SuppressLint("SetTextI18n")
    fun afficherTitre() {
        // récupérer un élément de la vue
        val txView = findViewById<TextView>(R.id.tv_example)
        // modifier le texte
        txView.text = "Calculateur de moyennes"
    }


    fun onClickButtonAdd(view: View) {
        // vider le champ "Moyenne générale"
        val editTextAverage = findViewById<TextView>(R.id.txt_average)
        editTextAverage.text = ""

        // récupérer le champ "edt_note"
        val editTextNote = findViewById<EditText>(R.id.edt_note)
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
            // afficher les saies dans le logcat pour vérifier le remplissage du tableau
            println(notes)
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickButtonStop(view: View) {
        // récupérer le champ "Moyenne générale"
        val editTextAverage = findViewById<TextView>(R.id.txt_average)
        if (notes.isNotEmpty()) {
            // faire la moyenne des notes du tableau
            val average = notes.average()
            // modifier la valeur du champ "Moyenne générale"
            editTextAverage.text = "Moyenne générale : %.2f".format(average)
            // vider le tableau de notes
            notes.clear()
        } else {
            editTextAverage.text = ""
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // lien avec la vue activity_moyenne.xml
        setContentView(R.layout.activity_moyenne)

        afficherTitre()


        // à décommenter pour faire marcher
        // La version sans tableau
        // correctionWithoutTableau()
        // correctionWithTableau()

    }


    // TP4

    fun calculAverage(note1: Float, note2: Float, note3: Float): Float {
        return (note1 + note2 + note3) / 3.0f;
    }

    fun correctionWithoutTableau() {
        // Mettre notes en dur
        // Notes math
        var noteMath1 = 12.0f
        var noteMath2 = 8.0f
        var noteMath3 = 0.2f

        // Notes français
        var noteFrancais1 = 12.0f
        var noteFrancais2 = 8.0f
        var noteFrancais3 = 0.2f

        // Notes sports
        var noteSport1 = 12.0f
        var noteSport2 = 8.0f
        var noteSport3 = 0.2f


        // Calculer la moyenne de chaques matières
        val averageMath = calculAverage(noteMath1, noteMath2, noteMath3);
        val averageFrancais = calculAverage(noteFrancais1, noteFrancais2, noteFrancais3);
        val averageSport = calculAverage(noteSport1, noteSport2, noteSport3);

        // Calculer moyenne general (deux manières)
        val averageGeneral = (averageMath + averageFrancais + averageSport) / 3
        val averageGeneralVersion2 = calculAverage(averageMath, averageFrancais, averageSport);

        // Affiche la moyenne generale avec println
        println(String.format("EniDemoTp : Moyenne Generale %f", averageGeneral))
    }

    fun calculAverageTableau(notes: Array<Float>): Float {
        // Additionner toute les notes
        var sum = 0.0f
        for (note in notes) {
            sum += note;
        }
//
//        val noteList = listOf(10.0f,10F)
//        for (i in (0..notes.size)){
//            noteList.get(i)
//
//       }
        // Diviser la somme des notes par le nombre de notes
        return sum / notes.size;
    }

    fun correctionWithTableau() {
        // Mettre notes en dur
        // Notes math
        val mathGrades: Array<Float> = arrayOf(12.0f, 8.0f, 0.2f) // Array<Float>

        // Notes français
        val francaisGrades: Array<Float> = arrayOf(12.0f, 8.0f, 0.2f) // Array<Float>

        // Notes sports
        val sportGrades: Array<Float> = arrayOf(12.0f, 8.0f, 0.2f) // Array<Float>

        // Calculer la moyenne de chaque matière
        // Un autre manière de faire est d'appeler une méthode déjà existante sur kotlin "average" dans un Array
        // example :
        /*
        val averageMath = mathGrades.average()
        val averageFrancais = francaisGrades.average()
        val averageSport = sportGrades.average()
        */
        val averageMath = calculAverageTableau(mathGrades);
        val averageFrancais = calculAverageTableau(francaisGrades);
        val averageSport = calculAverageTableau(sportGrades);

        // Calculer moyenne generale (deux manières)
        val averageGeneral = (averageMath + averageFrancais + averageSport) / 3
        val averageGeneralVersion2 = calculAverage(averageMath, averageFrancais, averageSport);

        // Affiche la moyenne générale avec println
        println(String.format("EniDemoTp : Moyenne Generale %.2f", averageGeneral))

        // Affiche la moyenne générale dans un TextView
        // récupérer le textView
        //val averageTextView = findViewById<TextView>(R.id.tv_average)
        // afficher le nouveau texte
        //averageTextView.text = String.format("Moyenne Générale : %.2f", averageGeneral)
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var personA = Person("Toto")
        var personB = Person("Sylvain")

        // afficher les 2 personnes avant modif
        println(String.format("ENI-DEMO: %s - %s", personA.firstName, personB.firstName))

        personB = personA
        personB.firstName = "Clint Eastwood"

        // affiche Clint Eastwood pour personA et personB
        println(String.format("ENI-DEMO: %s - %s", personA.firstName, personB.firstName))

        // Mon 1er code
        println("ENI-DEMO: Hello Android, you're better than IOS!!!!")


        // TP4 - Partie 1 - Sans tableau
        // mettre notes en dur
        val note1 = 10.0f
        val note2 = 5.0f
        val note3 = 15.0f
        val note4 = 10.0f

        // calculer la moyenne des notes en dur
        val notesMoyenne = calculerMoyenne(note1, note2, note3, note4)

        //afficher la moyenne avec println
        println(String.format("ENI-DEMO - La moyenne des notes est de : %f", notesMoyenne))

        // TP4 - Partie 2
        val notesMoyenneMath = calculerMoyenne(10.0f, 18.5f, 15.5f, 9.5f)
        println(String.format("ENI-DEMO - La moyenne de maths est de : %f", notesMoyenneMath))

        val notesMoyenneFrancais = calculerMoyenne(11.0f, 17.5f, 14.5f, 8.5f)
        println(String.format("ENI-DEMO - La moyenne de français est de : %f", notesMoyenneFrancais))

        val notesMoyenneHistoire = calculerMoyenne(12.0f, 16.5f, 13.5f, 18.5f)
        println(String.format("ENI-DEMO - La moyenne d'histoire est de : %f", notesMoyenneHistoire))

        val notesMoyenneSport = calculerMoyenne(18.0f, 16.5f, 17.0f, 18.5f)
        println(String.format("ENI-DEMO - La moyenne de sport est de : %f", notesMoyenneSport))

        // calculer moyenne générale
        val moyenneGenerale = calculerMoyenne(notesMoyenneMath, notesMoyenneFrancais, notesMoyenneHistoire, notesMoyenneSport)
        println(String.format("ENI-DEMO - La moyenne générale est de : %f", moyenneGenerale))

        // TP4 - Partie 3 - Avec un tableau
        val notes : Array<Float> = arrayOf(10.0f, 12.0f, 8.0f, 15.0f)
        val moyenne = calculerMoyenneTableau(notes)
        println(String.format("ENI-DEMO - La moyenne est de : %f", moyenne))

    }

    private fun calculerMoyenne(note1 : Float, note2 : Float, note3 : Float, note4 : Float) : Float {
        return ((note1 + note2 + note3 + note4) / 4)
    }

    private fun calculerMoyenneTableau(notes: Array<Float>): Float {
        var total = 0.0f
        for (note in notes) {
            total += note
        }
        return total / notes.size
    }
*/
}