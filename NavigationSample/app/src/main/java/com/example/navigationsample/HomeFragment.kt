package com.example.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        userViewModel.loggedIn.observe(viewLifecycleOwner, { hasLoggedIn ->
            if (hasLoggedIn.not()) {
                navController.navigate(R.id.action_homeFragment_to_signInFragment)
            }
        })

        view.findViewById<Button>(R.id.btnViewProfile).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment(nameArg = userViewModel.getUserName() ?: "")
            navController.navigate(action)
        }
    }

}