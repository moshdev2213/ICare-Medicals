package com.example.myapplication.APIServices

import com.example.myapplication.Entity.Appointment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AppointmentAPI {
    @POST("/api/appointment/create")
    fun createAppointment(@Body appointment: Appointment): Call<Appointment>
}