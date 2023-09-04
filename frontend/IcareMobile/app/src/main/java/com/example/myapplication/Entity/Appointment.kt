package com.example.myapplication.Entity

data class Appointment(
    val docEmail: String,
    val venue: String,
    val date: String,
    val time: String,
    val docName: String,
    val patEmail: String,
    val patName: String,
    val patNumber: String? = null ,// This is a nullable String
    val reference: Int,
    val amount: Double
)
