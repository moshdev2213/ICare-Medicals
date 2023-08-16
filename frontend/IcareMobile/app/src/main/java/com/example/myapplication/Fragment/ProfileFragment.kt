package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.Lifecycle
import com.example.myapplication.DialogAlerts.ProgressLoader
import com.example.myapplication.R
import com.example.myapplication.SignIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private  lateinit var cvLogoutUser:CardView
    private lateinit var progressLoader: ProgressLoader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        cvLogoutUser = view.findViewById(R.id.cvLogoutUser)
        cvLogoutUser.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                logout()
            }
        }
        return view
    }

    suspend fun logout(){
        progressLoader = ProgressLoader(
            requireContext(),"Logging Out","Please Wait....."
        )
        progressLoader.startProgressLoader()
            delay(2000)
        progressLoader.dismissProgressLoader()
            startActivity(Intent(requireActivity(), SignIn::class.java))
    }


}