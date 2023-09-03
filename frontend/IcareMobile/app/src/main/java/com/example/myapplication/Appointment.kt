package com.example.myapplication

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
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
    private lateinit var cvChannelDocAppo:CardView

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
        cvChannelDocAppo = findViewById(R.id.cvChannelDocAppo)

        tvRefDocAppo.text = generateRandom12DigitNumber().toString()
        tvPatientNameAppo.text = "Mr. "+patObj.firstName.capitalize()
        tvDocNameAppo.text = "Mr. "+doctor.firstName.capitalize()
        tvTotalDocCharge.text ="Rs. "+doctor.amount
        tvDocChargeAppo.text ="Rs. "+doctor.amount
        tvDateAppo.text = appointmentDate
        cvChannelDocAppo.setOnClickListener {
            sendNotification()
        }

    }
    fun generateRandom12DigitNumber(): Long {
        val minValue = 1_000_000_000L // Minimum 12-digit number
        val maxValue = 9_999_999_999L // Maximum 12-digit number

        return Random.nextLong(minValue, maxValue)
    }
    private fun sendNotification() {
        val channelId = "your_channel_id"  // Create a notification channel (required for Android 8.0+)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.splash)
            .setContentTitle("ICAre Appointments")
            .setContentText("body")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create the notification channel (required for Android 8.0+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Your Channel Name",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Show the notification
        notificationManager.notify(0, notificationBuilder.build())
    }


}