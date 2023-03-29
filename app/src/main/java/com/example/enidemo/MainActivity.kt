package com.example.enidemo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // lien avec la vue activity_main.xml
        setContentView(R.layout.activity_main)

    }

    // appeler la MoyenneActivity
    fun onClick(view: View){
        val intentActivity = Intent(this, MoyenneActivity::class.java)
        startActivity(intentActivity)
    }

}