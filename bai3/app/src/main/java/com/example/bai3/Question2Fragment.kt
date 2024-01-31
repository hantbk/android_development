package com.example.bai3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class Question2Fragment : Fragment() {

    private val correctAnswer = "Beijing" // Đáp án đúng cho câu hỏi 2
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question2, container, false)

        val nextButton = view.findViewById<Button>(R.id.nextButton2)
        val optionsRadioGroup = view.findViewById<RadioGroup>(R.id.optionsRadioGroup)
        navController = findNavController()

        nextButton.setOnClickListener {
            val selectedOptionId = optionsRadioGroup.checkedRadioButtonId
            val selectedOption = view.findViewById<RadioButton>(selectedOptionId)

            if (selectedOption != null) {
                val answer = selectedOption.text.toString()
                if (answer == correctAnswer) {
                    result += 1
                }
                navController.navigate(R.id.action_question2Fragment_to_question3Fragment)
            } else {
                // Handle the case where the user did not select an answer
                Toast.makeText(requireContext(), "Please select an answer", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}

