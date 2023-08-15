package com.example.myapplication.APIServices

import com.example.myapplication.Entity.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Authentication {
    @POST("/api/auth/register/patient")
    fun createPatient(@Body patient:Patient): Call<Patient>

    @GET("/api/auth/login/{email}")
    fun getUserExist(@Path(value = "email") email:String):Call<Patient>
}