package com.example.myapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication.APIServices.Authentication
import com.example.myapplication.DialogAlerts.ProgressLoader
import com.example.myapplication.Entity.Address
import com.example.myapplication.Entity.Patient
import com.example.myapplication.FromData.UserSignUp
import com.example.myapplication.RetrofitService.RetrofitService
import com.example.myapplication.Validations.ValidationResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.logging.Level
import java.util.logging.Logger


class Registration : AppCompatActivity() {
    private lateinit var btnSignUp:Button
    private lateinit var tvSignIn:TextView
    private lateinit var etRePassSignUp:EditText
    private lateinit var etPassSignUp:EditText
    private lateinit var etEmailSignUp:EditText
    private var count:Int =0
    private lateinit var progressLoader: ProgressLoader

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etEmailSignUp = findViewById(R.id.etEmailSignUp)
        etPassSignUp = findViewById(R.id.etPassSignUp)
        etRePassSignUp = findViewById(R.id.etRePassSignUp)
        tvSignIn = findViewById(R.id.tvSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)

        tvSignIn.setOnClickListener {
            startActivity(Intent(this@Registration,SignIn::class.java))
            finish()
        }
        btnSignUp.setOnClickListener{
            val email =etEmailSignUp.text.toString()
            val password =etPassSignUp.text.toString()
            val repass =etRePassSignUp.text.toString()

            userRegister(email,password,repass)
        }
    }

    private fun userRegister(email: String, password: String,repass:String) {
        regValidator(email,password,repass)


        if(count==2){
            progressLoader = ProgressLoader(
                this@Registration,"Registering.....","Please Wait"
            )
            progressLoader.startProgressLoader()

            val retrofitService = RetrofitService()
            val authentication : Authentication = retrofitService.getRetrofit().create(Authentication::class.java)

            authentication.getUserExist(email).enqueue(object:Callback<Patient>{
                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                    if(response.isSuccessful){
                        val patient = response.body()
                        if(patient !=null){
                            Toast.makeText(this@Registration,"Already Exist", Toast.LENGTH_SHORT).show()
                            progressLoader.dismissProgressLoader()
                        }
                    }else{
                        regUser(authentication, email, password)
                        progressLoader.dismissProgressLoader()
                    }
                }
                override fun onFailure(call: Call<Patient>, t: Throwable) {
                    Toast.makeText(this@Registration,"Failed", Toast.LENGTH_SHORT).show()
                    progressLoader.dismissProgressLoader()
                }

            })
            count=0;
        }
        count=0;
    }

    private fun regUser(authentication: Authentication,email:String,password: String){
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX")
        val formattedDate = dateFormat.format(Date())

        val call: Call<Patient> = authentication.createPatient(
            Patient(
                email,
                password,
                "",
                "",
                "",
                "",
                "",
                0,
                Address(
                    "",
                    "",
                    ""
                ),
                formattedDate,
                ""
            )
        )
        call.enqueue(object : Callback<Patient> {

            override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                Logger.getLogger(Registration::class.java.name).log(Level.SEVERE, "Error", response)
                if (response.isSuccessful){
                    val patient: Patient? = response.body()
                    if(patient !=null){
                        startActivity(Intent(this@Registration,Home::class.java))
                        finish()
                    }
                }else{
                    Toast.makeText(this@Registration,"UnSuccessesResponse", Toast.LENGTH_SHORT).show()

                }
            }
            override fun onFailure(call: Call<Patient>, t: Throwable) {
                Logger.getLogger(Registration::class.java.name).log(Level.SEVERE, "Error", t)
                Toast.makeText(this@Registration,"Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun regValidator(email: String, password: String, repass: String) {
        val userSignUp = UserSignUp(
            email,
            password,
            repass
        )
        val emailValidation =userSignUp.validateEmail()
        val passwordValidation =userSignUp.validatePassword()

        when(emailValidation){
            is ValidationResult.Valid ->{ count ++ }
            is ValidationResult.Invalid ->{
                etEmailSignUp.error =emailValidation.errorMsg

            }
            is ValidationResult.Empty ->{
                etEmailSignUp.error =emailValidation.errorMsg

            }
        }

        when(passwordValidation){
            is ValidationResult.Valid ->{ count ++ }
            is ValidationResult.Invalid ->{
                etPassSignUp.error =passwordValidation.errorMsg

            }
            is ValidationResult.Empty ->{
                etPassSignUp.error =passwordValidation.errorMsg

            }
        }
    }
}