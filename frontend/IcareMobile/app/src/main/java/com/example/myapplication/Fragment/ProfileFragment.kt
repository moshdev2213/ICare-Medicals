package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.example.myapplication.DialogAlerts.ProgressLoader
import com.example.myapplication.EntityDao.LoginDao
import com.example.myapplication.SignIn
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private  lateinit var cvLogoutUser:CardView
    private lateinit var progressLoader: ProgressLoader

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val out = arguments?.getSerializable("patientEmPass",LoginDao::class.java)
        Toast.makeText(requireContext(),out?.email,Toast.LENGTH_SHORT).show()

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