package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication.Entity.Patient
import com.example.myapplication.EntityDao.LoginDao

class MyProfile : AppCompatActivity() {
    private lateinit var imgBackPro:ImageView
    private lateinit var tvBloodTypePro:TextView
    private lateinit var tvEmailPro:TextView
    private lateinit var spDistrictPro:Spinner
    private lateinit var spProvincePro:Spinner
    private lateinit var spGenderPro:Spinner
    private lateinit var spBloodPro:Spinner
    private lateinit var etAgePro:EditText
    private lateinit var etStreetPro:EditText
    private lateinit var etUNamePro:EditText
    private lateinit var etLNamePro:EditText
    private lateinit var etFNamePro:EditText
    private lateinit var etPasswordPro:EditText
    private lateinit var etEmailPro:EditText

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        //for the data incoming from the login
        val bundle = intent.extras
        val receivedPatient = bundle?.getSerializable("patientObj", Patient::class.java)
        initViews()
        println(receivedPatient?.email)
        imgBackPro.setOnClickListener {
            finish()
        }
    }
    private fun initViews(){
        imgBackPro = findViewById(R.id.imgBackPro)
        tvBloodTypePro = findViewById(R.id.tvBloodTypePro)
        tvEmailPro = findViewById(R.id.tvEmailPro)
        spDistrictPro = findViewById(R.id.spDistrictPro)
        spProvincePro = findViewById(R.id.spProvincePro)
        spGenderPro = findViewById(R.id.spGenderPro)
        spBloodPro = findViewById(R.id.spBloodPro)
        etAgePro = findViewById(R.id.etAgePro)
        etStreetPro = findViewById(R.id.etStreetPro)
        etUNamePro = findViewById(R.id.etUNamePro)
        etLNamePro = findViewById(R.id.etLNamePro)
        etFNamePro = findViewById(R.id.etFNamePro)
        etPasswordPro = findViewById(R.id.etPasswordPro)
        etEmailPro = findViewById(R.id.etEmailPro)
    }
}