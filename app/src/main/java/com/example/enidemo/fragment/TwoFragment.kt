package com.example.enidemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enidemo.R

/**
 * A simple [Fragment] subclass.
 */
class TwoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // récupérer les arguments
        val args = arguments?.let { TwoFragmentArgs.fromBundle(it) }
        val name = args?.nom
        val code = args?.code

        // test de récupération des arguments
        println(String.format("ENI-DEMO : %s => %s", name, code))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

}