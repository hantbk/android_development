package com.example.navigationsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ProfileFragment : Fragment() {
    val args: ProfileFragmentArgs by navArgs()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.nameArg
        Log.d("ProfileFragment", "Name: $name")
        view.findViewById<TextView>(R.id.textView)?.text = getString(R.string.welcome, name)

        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            userViewModel.logout().observe(viewLifecycleOwner, {
                findNavController().popBackStack()
            })
        }
    }
}