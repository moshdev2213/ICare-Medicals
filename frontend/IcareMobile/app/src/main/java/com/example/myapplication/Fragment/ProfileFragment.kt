package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.example.myapplication.DialogAlerts.ProgressLoader
import com.example.myapplication.Entity.Patient
import com.example.myapplication.EntityDao.LoginDao
import com.example.myapplication.Home
import com.example.myapplication.MyProfile
import com.example.myapplication.SignIn
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private  lateinit var cvLogoutUser:CardView
    private lateinit var progressLoader: ProgressLoader
    private lateinit var tvProfileFragBloodType:TextView
    private lateinit var tvProfileFragEmail:TextView
    private lateinit var tvProfileFragName:TextView
    private lateinit var imgEditUser:ImageView
    private lateinit var cvDeleteUser:CardView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val out = arguments?.getSerializable("patientObject",Patient::class.java)


        cvLogoutUser = view.findViewById(R.id.cvLogoutUser)
        tvProfileFragEmail = view.findViewById(R.id.tvProfileFragEmail)
        tvProfileFragBloodType = view.findViewById(R.id.tvProfileFragBloodType)
        tvProfileFragName = view.findViewById(R.id.tvProfileFragName)
        imgEditUser = view.findViewById(R.id.imgEditUser)
        cvDeleteUser = view.findViewById(R.id.cvDeleteUser)

        tvProfileFragName.text = out?.firstName+" "+out?.lastName
        tvProfileFragEmail.text = out?.email
        tvProfileFragBloodType.text = out?.bloodGroup?.takeIf { it.isNotEmpty() } ?: "N/A"

        cvLogoutUser.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                logout()
            }
        }
        imgEditUser.setOnClickListener {
            val bundle = Bundle()
            val intent = Intent(requireContext(), MyProfile::class.java)
            bundle.putSerializable("patientObj",out)
            startActivity(intent)
        }
        return view
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private suspend fun logout(){
        progressLoader = ProgressLoader(
            requireContext(),"Logging Out","Please Wait....."
        )
        progressLoader.startProgressLoader()
            delay(2000)
        progressLoader.dismissProgressLoader()
            startActivity(Intent(requireActivity(), SignIn::class.java))
    }


}