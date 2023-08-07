package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.Button
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragment.DoctorFragment
import com.example.myapplication.Fragment.IndexFragment
import com.example.myapplication.Fragment.ProfileFragment
import com.example.myapplication.Fragment.ReportFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    private lateinit var bottomNavigationView:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        replaceFrag(IndexFragment())

        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.profile->replaceFrag(ProfileFragment())
                R.id.home->replaceFrag(IndexFragment())
                R.id.reports->replaceFrag(ReportFragment())
                R.id.doctors->replaceFrag(DoctorFragment())

                else->{

                }
            }
            true
        }
    }
    private fun replaceFrag(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}