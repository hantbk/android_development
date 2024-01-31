package com.example.bai3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        navController = findNavController()

        val getStartedButton = view.findViewById<Button>(R.id.getStartedButton)
        getStartedButton.setOnClickListener {
            result = 0
            navController.navigate(R.id.action_welcomeFragment_to_question1Fragment)
        }

        return view
    }
}