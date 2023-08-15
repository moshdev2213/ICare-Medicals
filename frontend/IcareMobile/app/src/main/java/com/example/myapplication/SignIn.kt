package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.APIServices.Authentication
import com.example.myapplication.DialogAlerts.ProgressLoader
import com.example.myapplication.EntityDao.LoginDao
import com.example.myapplication.FromData.UserLoginForm
import com.example.myapplication.RetrofitService.RetrofitService
import com.example.myapplication.Validations.ValidationResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignIn : AppCompatActivity() {
    private lateinit var etPassSignIn:EditText
    private lateinit var etEmailSignIn:EditText
    private lateinit var btnSignIn:Button
    private lateinit var tvSignUp:TextView
    private lateinit var tvForgotPw:TextView
    private lateinit var progressLoader: ProgressLoader
    private var count = 0;

    private val myCoroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        etEmailSignIn = findViewById(R.id.etEmailSignIn)
        etPassSignIn = findViewById(R.id.etPassSignIn)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvSignUp = findViewById(R.id.tvSignUp)
        tvForgotPw = findViewById(R.id.tvForgotPw)

        tvSignUp.setOnClickListener {
            startActivity(Intent(this@SignIn,Registration::class.java))
            finish()
        }
        btnSignIn.setOnClickListener{
            val email =etEmailSignIn.text.toString()
            val password =etPassSignIn.text.toString()
            userLogin(email,password)
        }
    }

    private fun userLogin(email: String, password: String) {

        loginValidator(email,password)

        if(count==2){
            progressLoader = ProgressLoader(
                this@SignIn,"Vegging Login","Please Wait"
            )
            progressLoader.startProgressLoader()

            val retrofitService = RetrofitService()
            val authentication : Authentication = retrofitService.getRetrofit().create(Authentication::class.java)

            val call: Call<LoginDao> = authentication.userLogin(
                LoginDao(email,password)
            )
            call.enqueue(object : Callback<LoginDao>{

                override fun onResponse(call: Call<LoginDao>, response: Response<LoginDao>) {
                    if (response.isSuccessful){
                        val patient = response.body()
                        if(patient !=null){
                            startActivity(Intent(this@SignIn,Home::class.java))
                            progressLoader.dismissProgressLoader()
                            finish()
                        }
                    }else{
                        Toast.makeText(this@SignIn,"Invalid Credentials",Toast.LENGTH_SHORT).show()
                        progressLoader.dismissProgressLoader()
                    }
                }
                override fun onFailure(call: Call<LoginDao>, t: Throwable) {
                    Toast.makeText(this@SignIn,"Failed",Toast.LENGTH_SHORT).show()
                    progressLoader.dismissProgressLoader()

                }
            })
            count=0;
        }
        count=0;
    }

    private fun loginValidator(email: String,password: String){
        val userLoginForm =UserLoginForm(
            email,
            password
        )
        val emailValidation =userLoginForm.validateEmail()
        val passwordValidation =userLoginForm.validatePassword()

        when(emailValidation){
            is ValidationResult.Valid ->{ count ++ }
            is ValidationResult.Invalid ->{
                etEmailSignIn.error =emailValidation.errorMsg

            }
            is ValidationResult.Empty ->{
                etEmailSignIn.error =emailValidation.errorMsg

            }
        }

        when(passwordValidation){
            is ValidationResult.Valid ->{ count ++ }
            is ValidationResult.Invalid ->{
                etPassSignIn.error =passwordValidation.errorMsg

            }
            is ValidationResult.Empty ->{
                etPassSignIn.error =passwordValidation.errorMsg

            }
        }
    }
}