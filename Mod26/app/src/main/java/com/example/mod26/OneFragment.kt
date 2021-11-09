package com.example.mod26

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class OneFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//    super.onViewCreated(view, savedInstanceState)
//    button_next.setOnClickListener {
//        (activity as MainActivity).navController.navigate(R.id.threeFragment)
//    }
//
//    button_prev.setOnClickListener {
//        (activity as MainActivity).navController.popBackStack()
//    }

}