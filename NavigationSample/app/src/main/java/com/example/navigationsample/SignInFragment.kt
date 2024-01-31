package com.example.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class SignInFragment : Fragment() {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        view.findViewById<Button>(R.id.btnSignIn).setOnClickListener {
            userViewModel.login(
                view.findViewById<EditText>(R.id.editUsername).text.toString(),
                view.findViewById<EditText>(R.id.editPassword).text.toString()
            ).observe(viewLifecycleOwner, Observer { successful ->
                if (successful) {
                    navController.popBackStack()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Username or Password not correct",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }

        view.findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
}