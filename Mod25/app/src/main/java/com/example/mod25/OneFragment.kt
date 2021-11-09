package com.example.mod25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mod25.databinding.FragmentOneBinding


class OneFragment : Fragment() {
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOneBinding.inflate(layoutInflater)

        binding.imageButton.setOnClickListener {
            (activity as MainActivity).startSecondFragment(binding.imageButton)
        }
    }
}