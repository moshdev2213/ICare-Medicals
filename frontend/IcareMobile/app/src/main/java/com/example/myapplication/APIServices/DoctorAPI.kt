package com.example.myapplication.APIServices

import com.example.myapplication.Entity.Doctor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface DoctorAPI {

    @GET("/api/doctor/getAllDoctors/{status}")
    fun getAllDoctors(@Path (value = "status") status:Int):Call<List<Doctor>>

}