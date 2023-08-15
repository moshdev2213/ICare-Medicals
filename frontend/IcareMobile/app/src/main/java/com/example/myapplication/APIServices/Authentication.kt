package com.example.myapplication.APIServices

import com.example.myapplication.Entity.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Authentication {
    @POST("/api/register/patient")
    fun savePatient(@Body patient:Patient): Call<Patient>
}