package com.example.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {

    private lateinit var userInfoTextView:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        userInfoTextView = view.findViewById(R.id.userInfoTextView)
        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            userInfoTextView.text = "Welcome, \n${it.email}"
        }
        // Inflate the layout for this fragment
        return view
    }


}