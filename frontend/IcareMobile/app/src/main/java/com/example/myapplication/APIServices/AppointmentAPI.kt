package com.example.myapplication.APIServices

import com.example.myapplication.Entity.Appointment
import com.example.myapplication.Entity.Doctor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AppointmentAPI {
    @POST("/api/appointment/create")
    fun createAppointment(@Body appointment: Appointment): Call<Appointment>

    @GET("/api/appointment/getAllAppointments/{email}")
    fun getAllAppointments(@Path(value = "email")email:String):Call<List<Appointment>>
}