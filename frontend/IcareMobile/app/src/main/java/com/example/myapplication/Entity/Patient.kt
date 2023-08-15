package com.example.myapplication.Entity

data class Patient(
    val email:String,
    val password:String,
    val firstName:String,
    val lastName:String,
    val uname:String,
    val gender:String,
    val bloodGroup:String,
    val age:Int,
    val address: Address,
    val date: String
)
