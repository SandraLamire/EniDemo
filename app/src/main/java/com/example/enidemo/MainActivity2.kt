package com.example.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.enidemo.databinding.ActivityMainBinding
import com.example.enidemo.fragment.BlankFragmentDirections

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main2)

        onClick()
    }

    fun onClick() {
        // get navController - naviguer sans arguments
        // findNavController(R.id.navExample).navigate(R.id.action_blankFragment_to_twoFragment)

        // naviguer avec arguments
/*      // méthode 1
        var action = BlankFragmentDirections.actionBlankFragmentToTwoFragment()
        action.arguments.putString("code",10)
        action.arguments.putString("nom","Test")
*/
        // méthode 2
        val action = BlankFragmentDirections.actionBlankFragmentToTwoFragment()
        action.nom = "Test"
        action.code = 10
        // naviguer sur l'action préparée (fragment navHost id=navExample du activity_main.xml)
        findNavController(R.id.navExample).navigate(action)

    }

}