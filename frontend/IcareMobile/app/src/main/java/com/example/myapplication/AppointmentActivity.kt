package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.app.NotificationCompat
import com.example.myapplication.APIServices.AppointmentAPI
import com.example.myapplication.APIServices.EyeScanAPI
import com.example.myapplication.DialogAlerts.OkNoDialog
import com.example.myapplication.DialogAlerts.ProgressLoader
import com.example.myapplication.Entity.Appointment
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.Entity.Patient
import com.example.myapplication.EntityDao.EyeScanDao
import com.example.myapplication.EntityDao.LoginDao
import com.example.myapplication.RetrofitService.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class AppointmentActivity : AppCompatActivity() {
    private lateinit var doctor:Doctor
    private lateinit var patObj:Patient
    private lateinit var appointmentDate:String
    private lateinit var okNoDialog: OkNoDialog
    private lateinit var progressLoader: ProgressLoader

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
        okNoDialog = OkNoDialog(this@AppointmentActivity)
        progressLoader = ProgressLoader(this@AppointmentActivity,"Please Wait","We Are On It.......")

        tvRefDocAppo.text = generateRandom12DigitNumber().toString()
        tvPatientNameAppo.text = "Mr. "+patObj.firstName.capitalize()
        tvDocNameAppo.text = "Mr. "+doctor.firstName.capitalize()
        tvTotalDocCharge.text ="Rs. "+doctor.amount
        tvDocChargeAppo.text ="Rs. "+doctor.amount
        tvDateAppo.text = appointmentDate
        cvChannelDocAppo.setOnClickListener {
            progressLoader.startProgressLoader()
            val appointment = Appointment(doctor.email,
                doctor.venue,
                appointmentDate,
                getCurrentTimeInAMPM(),
                doctor.firstName,
                patObj.email,
                patObj.firstName,
                patObj.tel,
                generateRandom12DigitNumber().toInt(),
                doctor.amount
            )
            createAppointment(appointment)
        }

    }
    private fun createAppointment(appointment: Appointment){
        val retrofitService = RetrofitService()
        val appointmentAPI = retrofitService.getRetrofit().create(AppointmentAPI::class.java)
        println("pakoooo "+appointment)
        val call: Call<Appointment> = appointmentAPI.createAppointment(appointment)
        call.enqueue(object :Callback<Appointment>{
            @RequiresApi(Build.VERSION_CODES.TIRAMISU)
            override fun onResponse(call: Call<Appointment>, response: Response<Appointment>) {
                println(response.body())
                if(response.isSuccessful){

                    if (response.body()!=null){
                        progressLoader.dismissProgressLoader()
                        okNoDialog.dialogWithSuccess("Appointment Success"){
                            sendNotification(appointment)

                            val patientEmPass=LoginDao(
                                patObj.email,
                                patObj.password
                            )
                            val intent = Intent(this@AppointmentActivity, Home::class.java)
                            val bundle = Bundle().apply {
                                putSerializable("patientEmPass",patientEmPass)
                            }
                            intent.putExtras(bundle)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    progressLoader.dismissProgressLoader()
                    Toast.makeText(this@AppointmentActivity,"Invalid response", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Appointment>, t: Throwable) {
                println(t)
                progressLoader.dismissProgressLoader()
                Toast.makeText(this@AppointmentActivity,"Internal Server Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun generateRandom12DigitNumber(): Long {
        val minValue = 1_000_000_000L // Minimum 10-digit number
        val maxValue = 9_999_999_999L // Maximum 10-digit number

        return Random.nextLong(minValue, maxValue)
    }
    private fun getCurrentTimeInAMPM(): String {
        val dateFormat = SimpleDateFormat("hh:mm a", Locale.US)
        val currentTime = Date()
        return dateFormat.format(currentTime)
    }
    private fun sendNotification(appointment: Appointment) {
        val channelId = "your_channel_id"  // Create a notification channel (required for Android 8.0+)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.splash)
            .setContentTitle("ICAre Appointments")
            .setContentText("Appointment Confirmation And Scheduling.......")
            .setStyle(NotificationCompat.BigTextStyle().bigText(
                "Dear Mr. "+appointment.patName.capitalize()+",\n\n" +
                        "This is to confirm that your appointment with Dr. "+appointment.docName.capitalize()+" has been successfully scheduled for The Date "+appointment.date+","+appointment.time+" at "+appointment.venue.capitalize()+".\n" +
                        "Please make sure to arrive on time for your appointment. If you need to reschedule or have any questions, please contact us at 0371267865.\n\n" +
                        "Thank you for choosing our services. We look forward to serving you.\n" +
                        "Best regards,\n" +
                        "ICare Medicals Pvt.Ltd\n"
            ))
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