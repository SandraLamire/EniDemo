package com.example.enidemo


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.enidemo.databinding.ActivityMainBinding

class MainActivity1 : AppCompatActivity() {

    // le nom du XML en PascalCase avec suffixe Binding
    // lateinit permet d'autoriser les valeurs null
    private lateinit var activityMainBinding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activer le DataBinding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //activityMainBinding.tvTest.text = "Coucou"

        // lier une personne dans la vue
        // pas besoin de setter grâce au DataBinding
        //activityMainBinding.myPerson = Person("Sandra")

    }

    // appeler la MoyenneActivity
    fun onClickMoyenne(view: View){
        if(view is Button){
            val intentActivity = Intent(this, MoyenneActivity::class.java)
            startActivity(intentActivity)
        }
    }

    // appeler le QuizzActivity
    fun onClickQuizz(view: View){
        if(view is Button){
            val intentActivity = Intent(this, QuizzActivity::class.java)
            startActivity(intentActivity)
        }
    }
}