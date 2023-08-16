package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.myapplication.APIServices.EyeScanAPI
import com.example.myapplication.EntityDao.EyeScanDao
import com.example.myapplication.RealPathUtil.RealPathUtil
import com.example.myapplication.RetrofitService.RetrofitService
import com.facebook.shimmer.ShimmerFrameLayout
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
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

    private lateinit var tvEyeScanRiskLevel:TextView
    private lateinit var tvEyeScanType:TextView
    private lateinit var tvMainNameDis:TextView
    private lateinit var textView61:TextView

    private lateinit var shimmerScan: ShimmerFrameLayout

    private lateinit var path:String

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

        tvEyeScanRiskLevel = findViewById(R.id.tvEyeScanRiskLevel)
        tvEyeScanType = findViewById(R.id.tvEyeScanType)
        tvMainNameDis = findViewById(R.id.tvMainNameDis)

        shimmerScan = findViewById(R.id.shimmerScan)


        imgBack.setOnClickListener {
            finish()
        }
        cvScanEyeAct.setOnClickListener {

            imgPlaceHolderUpload.visibility = View.GONE
            ImagePicker.with(this@EyeScan)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imgEyeUploadPreview.setImageURI(data?.data)


        val outputDateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
        val date = Date() // Replace this with your desired date
        val formattedDate = outputDateFormat.format(date)
        tvScanDate.text = formattedDate

        val outputTimeFormat = SimpleDateFormat("hh.mm a", Locale.getDefault())

        val currentTime = Calendar.getInstance().time
        val formattedTime = outputTimeFormat.format(currentTime)
        tvScanTime.text = formattedTime

        if (data != null) {
            path = data.data?.let {
                RealPathUtil().getRealPath(this@EyeScan, it).toString()
            }.toString()

        }
        shimmerScan.startShimmer()
        shimmerScan.visibility = View.VISIBLE
        cvEyeScanResult.visibility = View.GONE
        scanEyeImage()
    }

      private fun scanEyeImage(){
        val file = File(path)
        val reqBody = RequestBody.create(MediaType.parse("multipart/form-data"),file)
        val body = MultipartBody.Part.createFormData("image",file.name,reqBody)

        val retrofitService = RetrofitService()
        val scanApi = retrofitService.getRetrofit().create(EyeScanAPI::class.java)

        val call:Call<EyeScanDao> = scanApi.eyeScanPredict(body)
        call.enqueue(object : Callback<EyeScanDao> {
            override fun onResponse(call: Call<EyeScanDao>, response: Response<EyeScanDao>) {
                if(response.isSuccessful){

                    if (response.body()!=null){
                        shimmerScan.stopShimmer()
                        shimmerScan.visibility = View.GONE
                        cvEyeScanResult.visibility = View.VISIBLE
                        populateViews(response)
                    }
                }else{
                    Toast.makeText(this@EyeScan,"Invalid response", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<EyeScanDao>, t: Throwable) {
                Toast.makeText(this@EyeScan,"Failed",Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun populateViews(response: Response<EyeScanDao>){

        val predictions= response.body()?.predictions

        // Get the first three predictions
        val topThreePredictions = predictions?.take(3)

        if(topThreePredictions!=null){


            // Filter out disease with specific tag names
            val tagNamesToDisplay  = listOf(
                    "diabetic_retinopathy_scan",
                    "glaucoma_scan",
                    "cataract_scan",
                    "cellulitis_pic",
                    "normal_scan",
                    "uveitis_pic",
                    "glaucoma_pic",
                    "cataract_pic",
                    "crossed_eyes_pic",
                    "conjunctivitis_pic",
                    "bulging_eyes_pic"
            )

            val tagPrintNames = mapOf(
                "diabetic_retinopathy_scan" to "Diabetic Retinopathy",
                "glaucoma_scan" to "Glaucoma",
                "cataract_scan" to "Cataract",
                "cellulitis_pic" to "Cellulitis",
                "normal_scan" to "Healthy",
                "uveitis_pic" to "Uveitis",
                "glaucoma_pic" to "Glaucoma",
                "cataract_pic" to "Cataract",
                "crossed_eyes_pic" to "Crossed Eyes",
                "conjunctivitis_pic" to "Conjunctivitis",
                "bulging_eyes_pic" to "Bulging Eye"
            )

            // Filter and sort predictions by highest probability
            val sortedPredictions = topThreePredictions
                .filter { it.tagName in tagNamesToDisplay }
                .sortedByDescending { it.probability.toDouble() }

            println("dsdsds "+sortedPredictions)

             var type = ""
             var riskRange=""
            for((index,predict) in sortedPredictions.withIndex()){
                val probability = predict.probability.toDouble() * 100
                val printname = tagPrintNames[predict.tagName]

                if (index == 0) {
                    type = when {
                        predict.tagName.endsWith("_scan", ignoreCase = true) -> "Scanned"
                        predict.tagName.endsWith("_pic", ignoreCase = true) -> "Not Scanned"
                        else -> "Not Found"
                    }
                    riskRange = when{
                        probability< 45 ->"Low"
                            probability< 75 ->"Moderate"
                            else ->"High"
                    }
                    tvEyeScanRiskLevel.text = "${String.format("%.4f", probability)} %"
                    tvMainNameDis.text = printname
                    tvEyeScanType.text = type
                }

                // Set the probabilities to the TextViews
                val textViewProbabiltyResourceId = resources.getIdentifier("tvPredictRate${String.format("%02d", index+1)}", "id", packageName)
                val tvProb = findViewById<TextView>(textViewProbabiltyResourceId)
                tvProb.text = "${String.format("%.4f", probability)} %"

                val textViewNameResourceId = resources.getIdentifier("tvPredictDisName${String.format("%02d", index+1)}", "id", packageName)
                val tvDisName = findViewById<TextView>(textViewNameResourceId)
                tvDisName.text = printname

                val textColor =when(riskRange){
                    "Low" -> Color.GREEN
                    "Moderate" -> Color.YELLOW
                    "High" -> Color.RED
                    else -> Color.GREEN
                }
                tvProb.setTextColor(textColor)
                tvEyeScanRiskLevel.setTextColor(textColor)
            }
        }

    }
}