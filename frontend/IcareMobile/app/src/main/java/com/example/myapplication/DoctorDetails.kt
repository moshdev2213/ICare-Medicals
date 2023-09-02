package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.example.myapplication.Entity.Doctor
import java.text.SimpleDateFormat
import java.util.Locale


class DoctorDetails : AppCompatActivity() {
    private lateinit var tvDocTimeRangeDetail:TextView
    private lateinit var tvDocNameDetail:TextView
    private lateinit var tvDocSpecialDetail:TextView
    private lateinit var tvDocLocationDetail:TextView
    private lateinit var imgDocPicDetail:ImageView
    private lateinit var tvDocExpDetail:TextView
    private lateinit var tvDocJoinedDetail:TextView
    private lateinit var tvDocDetailText:TextView
    private lateinit var cvChannel:CardView

    private lateinit var doctor:Doctor

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)

        val bundle = intent.extras
        doctor = bundle?.getSerializable("doctor", Doctor::class.java)!!

        tvDocExpDetail = findViewById(R.id.tvDocExpDetail)
        tvDocNameDetail = findViewById(R.id.tvDocNameDetail)
        tvDocJoinedDetail = findViewById(R.id.tvDocJoinedDetail)
        tvDocTimeRangeDetail = findViewById(R.id.tvDocTimeRangeDetail)
        tvDocSpecialDetail = findViewById(R.id.tvDocSpecialDetail)
        tvDocLocationDetail = findViewById(R.id.tvDocLocationDetail)
        tvDocDetailText = findViewById(R.id.tvDocDetailText)
        imgDocPicDetail = findViewById(R.id.imgDocPicDetail)
        cvChannel = findViewById(R.id.cvChannel)

        tvDocNameDetail.text = doctor.firstName.capitalize()
        tvDocSpecialDetail.text = doctor.specializing
        tvDocLocationDetail.text = doctor.venue

        tvDocTimeRangeDetail.text=doctor.timeAvailabe
        tvDocExpDetail.text=doctor.cured.toString()
        tvDocDetailText.text = doctor.description

        val originalDateString = doctor.added

        // Parse the original date string
        val originalDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault())
        val originalDate = originalDateFormat.parse(originalDateString)

        // Create a new date format for the desired output format
        val desiredDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Format the date to the desired format
        val formattedDate = desiredDateFormat.format(originalDate)
        tvDocJoinedDetail.text = formattedDate


    }
}