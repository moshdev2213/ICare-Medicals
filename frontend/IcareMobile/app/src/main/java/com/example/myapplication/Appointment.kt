package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.Entity.Patient
import kotlin.random.Random

class Appointment : AppCompatActivity() {
    private lateinit var doctor:Doctor
    private lateinit var patObj:Patient
    private lateinit var appointmentDate:String

    private lateinit var tvRefDocAppo:TextView
    private lateinit var tvPatientNameAppo:TextView
    private lateinit var tvDateAppo:TextView
    private lateinit var tvDocNameAppo:TextView
    private lateinit var tvTotalDocCharge:TextView
    private lateinit var tvDocChargeAppo:TextView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)
        val bundle = intent.extras
        doctor = bundle?.getSerializable("doctor", Doctor::class.java)!!
        patObj = bundle?.getSerializable("patObj", Patient::class.java)!!
        appointmentDate = bundle?.getString("appointmentDate")!!

        tvRefDocAppo = findViewById(R.id.tvRefDocAppo)
        tvPatientNameAppo = findViewById(R.id.tvPatientNameAppo)
        tvDateAppo = findViewById(R.id.tvDateAppo)
        tvDocNameAppo = findViewById(R.id.tvDocNameAppo)
        tvTotalDocCharge = findViewById(R.id.tvTotalDocCharge)
        tvDocChargeAppo = findViewById(R.id.tvDocChargeAppo)

        tvRefDocAppo.text = generateRandom12DigitNumber().toString()
        tvPatientNameAppo.text = "Mr. "+patObj.firstName.capitalize()
        tvDocNameAppo.text = "Mr. "+doctor.firstName.capitalize()
        tvTotalDocCharge.text ="Rs. "+doctor.amount
        tvDocChargeAppo.text ="Rs. "+doctor.amount
        tvDateAppo.text = appointmentDate


    }
    fun generateRandom12DigitNumber(): Long {
        val minValue = 1_000_000_000L // Minimum 12-digit number
        val maxValue = 9_999_999_999L // Maximum 12-digit number

        return Random.nextLong(minValue, maxValue)
    }
}