package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.myapplication.EyeDiseases
import com.example.myapplication.EyeScan
import com.example.myapplication.Home
import com.example.myapplication.R

class IndexFragment : Fragment() {
    private lateinit var cvScanEye:CardView
    private lateinit var cvChannel:CardView
    private lateinit var cvDisease:CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_index, container, false)

        val home = requireActivity() as Home
        cvScanEye =view.findViewById(R.id.cvScanEye)
        cvDisease =view.findViewById(R.id.cvDisease)
        cvChannel =view.findViewById(R.id.cvChannel)

        cvScanEye.setOnClickListener {
            startActivity(Intent(requireActivity(),EyeScan::class.java))
        }
        cvDisease.setOnClickListener {
            startActivity(Intent(requireActivity(),EyeDiseases::class.java))
        }

        return view
    }


}