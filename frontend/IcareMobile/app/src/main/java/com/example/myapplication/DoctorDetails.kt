package com.example.myapplication

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.Entity.Patient
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class DoctorDetails : AppCompatActivity() {
    private lateinit var tvDocTimeRangeDetail:TextView
    private lateinit var tvDocNameDetail:TextView
    private lateinit var tvDocSpecialDetail:TextView
    private lateinit var tvDocLocationDetail:TextView
    private lateinit var imgDocPicDetail:ImageView
    private lateinit var imgBackBtn:ImageView
    private lateinit var tvDocExpDetail:TextView
    private lateinit var tvDocJoinedDetail:TextView
    private lateinit var tvDocDetailText:TextView
    private lateinit var tvDocChargesDetails:TextView
    private lateinit var cvChannel:CardView

    private lateinit var doctor:Doctor
    private lateinit var patObj:Patient
    private lateinit var datePickerDialog: DatePickerDialog
    var selectedDate =""

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)

        val bundle = intent.extras
        doctor = bundle?.getSerializable("doctor", Doctor::class.java)!!
        patObj = bundle?.getSerializable("patObj",Patient::class.java)!!

        tvDocExpDetail = findViewById(R.id.tvDocExpDetail)
        tvDocChargesDetails = findViewById(R.id.tvDocChargesDetails)
        tvDocNameDetail = findViewById(R.id.tvDocNameDetail)
        tvDocJoinedDetail = findViewById(R.id.tvDocJoinedDetail)
        tvDocTimeRangeDetail = findViewById(R.id.tvDocTimeRangeDetail)
        tvDocSpecialDetail = findViewById(R.id.tvDocSpecialDetail)
        tvDocLocationDetail = findViewById(R.id.tvDocLocationDetail)
        tvDocDetailText = findViewById(R.id.tvDocDetailText)
        imgDocPicDetail = findViewById(R.id.imgDocPicDetail)
        imgBackBtn = findViewById(R.id.imgBackBtn)
        cvChannel = findViewById(R.id.cvChannel)

        tvDocNameDetail.text = doctor.firstName.capitalize()
        tvDocSpecialDetail.text = doctor.specializing
        tvDocLocationDetail.text = doctor.venue

        tvDocTimeRangeDetail.text=doctor.timeAvailabe
        tvDocExpDetail.text=doctor.cured.toString()
        tvDocDetailText.text = doctor.description
        tvDocChargesDetails.text = "Rs. "+doctor.amount
        imgBackBtn.setOnClickListener {
            finish()
        }

        tvDocJoinedDetail.text = getFormattedDate(doctor.added)
        cvChannel.setOnClickListener {
            // Get the current date
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)


            datePickerDialog=DatePickerDialog(this,R.style.DialogTheme,
                { datePicker: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                    // Handle the selected date
                    selectedDate = "$selectedYear.${selectedMonth + 1}.$selectedDay"
                    val intent = Intent(this,AppointmentActivity::class.java)
                    val bundle = Bundle().apply {
                        putSerializable("doctor", doctor)
                        putSerializable("patObj",patObj)
                        putString("appointmentDate",selectedDate)
                    }
                    intent.putExtras(bundle)
                    startActivity(intent)
                    finish()
                },year,month,day)

            // Show the DatePickerDialog
            datePickerDialog.show()

            // Prevent the dialog from closing when touched outside
            datePickerDialog.setCanceledOnTouchOutside(false)
            val negativeButton = datePickerDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            val positiveButton = datePickerDialog.getButton(DialogInterface.BUTTON_POSITIVE)

            positiveButton.setTextColor(ContextCompat.getColor(this, R.color.bg_btn
            ))
            negativeButton.visibility = View.GONE
        }

    }

    private fun getFormattedDate(date:String): String {
        val originalDateString = date

        // Parse the original date string
        val originalDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault())
        val originalDate = originalDateFormat.parse(originalDateString)

        // Create a new date format for the desired output format
        val desiredDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Format the date to the desired format
        return desiredDateFormat.format(originalDate)
    }
}