package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.myapplication.APIServices.Authentication
import com.example.myapplication.Entity.Patient
import com.example.myapplication.EntityDao.LoginDao
import com.example.myapplication.Fragment.DoctorFragment
import com.example.myapplication.Fragment.IndexFragment
import com.example.myapplication.Fragment.ProfileFragment
import com.example.myapplication.Fragment.ReportFragment
import com.example.myapplication.RetrofitService.RetrofitService
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class Home : AppCompatActivity() {
    private lateinit var bottomNavigationView:BottomNavigationView
    private lateinit var frameLayout: FrameLayout
    private lateinit var shimmerScan: ShimmerFrameLayout
    private var patientObject:Patient?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        frameLayout = findViewById(R.id.frame_layout)
        shimmerScan = findViewById(R.id.shimmerIndexActivity)

        //for the data incoming from the login
        val receivedPatient = intent.getSerializableExtra("patientEmPass", LoginDao::class.java)

         getPatientDetails(receivedPatient){patient->
            if (patient!=null){
                patientObject=patient
            }
        }

        replaceFrag(IndexFragment(),patientObject)
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.profile->replaceFrag(ProfileFragment(),patientObject)
                R.id.home->replaceFrag(IndexFragment(),patientObject)
                R.id.reports->replaceFrag(ReportFragment(),patientObject)
                R.id.doctors->replaceFrag(DoctorFragment(),patientObject)

                else->{

                }
            }
            true
        }
    }
    private fun replaceFrag(fragment: Fragment , patient: Patient ?=null){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        if(patient !=null){
            val bundle = Bundle()
            bundle.putSerializable("patientObject",patient)
            fragment.arguments = bundle
        }

        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

    private fun getPatientDetails(
        receivedPatient:LoginDao?=null,
        callback: (Patient?) -> Unit
    ) {

        bottomNavigationView.visibility = View.GONE
        frameLayout.visibility = View.GONE
        shimmerScan.startShimmer()


        val retrofitService = RetrofitService()
        val authentication : Authentication = retrofitService.getRetrofit().create(Authentication::class.java)
        if(receivedPatient!=null){
            val call: Call<Patient> = authentication.getUserExist(receivedPatient.email)
            call.enqueue(object : Callback<Patient>{
                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                    if (response.isSuccessful){
                        val returnPatient = response.body()
                        bottomNavigationView.visibility = View.VISIBLE
                        frameLayout.visibility = View.VISIBLE
                        shimmerScan.stopShimmer()
                        shimmerScan.visibility = View.GONE

                        callback(returnPatient)
                    }else{
                        Toast.makeText(this@Home,"Invalid Email", Toast.LENGTH_SHORT).show()
                        callback(null)
                    }
                }
                override fun onFailure(call: Call<Patient>, t: Throwable) {
                    Toast.makeText(this@Home,"Server Error", Toast.LENGTH_SHORT).show()
                    callback(null)
                }
            })
        }
    }
}