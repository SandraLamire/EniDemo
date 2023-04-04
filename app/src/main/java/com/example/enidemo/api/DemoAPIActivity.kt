package com.example.enidemo.api

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.enidemo.R
import kotlinx.coroutines.launch

class DemoAPIActivity : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_apiactivity)

        // appel API
        lifecycleScope.launch {
            // appel du service https://api.chucknorris.io/jokes/random
            val joke = ChuckApi.retrofitService.randomFact()
            println(String.format("ENI-DEMO : La blague est : %s", joke.value))

        }
    }

//    fun apiLauch(){
//        // afficher barre de chargement pendant appel API
//        progressDialog = ProgressDialog(this@DemoAPIActivity)
//        ProgressDialog.setTitle("Chargement")
//        ProgressDialog.setMessage("Go to Chuck Norris service, please wait")
//        ProgressDialog.show()
//
//        // appel API
//        lifecycleScope.launch {
//            // appel du service https://api.chucknorris.io/jokes/random
//            val joke = ChuckApi.retrofitService.randomFact()
//            println(String.format("ENI-DEMO : La blague est : %s", joke.value))
//
//
//            // masquer barre de chargement après réponse de l'API
//            ProgressDialog.hide()
//    }
}