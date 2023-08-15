package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.github.dhaval2404.imagepicker.ImagePicker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class EyeScan : AppCompatActivity() {
    private lateinit var cvScanEyeAct:CardView
    private lateinit var imgBack:ImageView
    private lateinit var imgPlaceHolderUpload:ImageView

    //The directives for card
    private lateinit var imgEyeUploadPreview:ImageView
    private lateinit var cvEyeScanResult:CardView
    private lateinit var cvEyeScanChannelDoc:CardView

    private lateinit var tvScanTime:TextView
    private lateinit var tvScanDate:TextView

    private lateinit var tvPredictRate01:TextView
    private lateinit var tvPredictRate02:TextView
    private lateinit var tvPredictRate03:TextView

    private lateinit var tvPredictName01:TextView
    private lateinit var tvPredictName02:TextView
    private lateinit var tvPredictName03:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_scan)

        imgBack = findViewById(R.id.imgBack)
        cvScanEyeAct = findViewById(R.id.cvScanEyeAct)
        imgPlaceHolderUpload = findViewById(R.id.imgPlaceHolderUpload)

        imgEyeUploadPreview = findViewById(R.id.imgEyeUploadPreview)
        cvEyeScanResult = findViewById(R.id.cvEyeScanResult)
        cvEyeScanChannelDoc = findViewById(R.id.cvEyeScanChannelDoc)
        tvScanTime = findViewById(R.id.tvScanTime)
        tvScanDate = findViewById(R.id.tvScanDate)
        tvPredictRate01 = findViewById(R.id.tvPredictRate01)
        tvPredictRate02 = findViewById(R.id.tvPredictRate02)
        tvPredictRate03 = findViewById(R.id.tvPredictRate03)
        tvPredictName01 = findViewById(R.id.tvPredictName01)
        tvPredictName02 = findViewById(R.id.tvPredictName02)
        tvPredictName03 = findViewById(R.id.tvPredictName03)


        imgBack.setOnClickListener {
            finish()
        }
        cvScanEyeAct.setOnClickListener {
            ImagePicker.with(this@EyeScan)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imgPlaceHolderUpload.visibility = View.GONE
        cvEyeScanResult.visibility = View.VISIBLE
        imgEyeUploadPreview.setImageURI(data?.data)

        val outputDateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
        val date = Date() // Replace this with your desired date
        val formattedDate = outputDateFormat.format(date)
        tvScanDate.text = formattedDate

        val outputTimeFormat = SimpleDateFormat("hh.mm a", Locale.getDefault())

        val currentTime = Calendar.getInstance().time
        val formattedTime = outputTimeFormat.format(currentTime)
        tvScanTime.text = formattedTime
    }
}