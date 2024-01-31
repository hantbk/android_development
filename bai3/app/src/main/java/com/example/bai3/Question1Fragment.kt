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
import androidx.navigation.fragment.findNavController

class Question1Fragment : Fragment() {

    private val correctAnswer = "Paris" // Đáp án đúng cho câu hỏi 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question1, container, false)

        val nextButton = view.findViewById<Button>(R.id.nextButton1)
        val optionsRadioGroup = view.findViewById<RadioGroup>(R.id.optionsRadioGroup)

        nextButton.setOnClickListener {
            val selectedOptionId = optionsRadioGroup.checkedRadioButtonId
            val selectedOption = view.findViewById<RadioButton>(selectedOptionId)

            if (selectedOption != null) {
                val answer = selectedOption.text.toString()
                if (answer == correctAnswer) {
                    result +=1
                }
                val action = Question1FragmentDirections.actionQuestion1FragmentToQuestion2Fragment()
                findNavController().navigate(action)
            } else {
                // Handle the case where the user did not select an answer
                Toast.makeText(requireContext(), "Please select an answer", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}

