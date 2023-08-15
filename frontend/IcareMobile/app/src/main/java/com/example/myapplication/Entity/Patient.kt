package com.example.myapplication.Entity

data class Patient(
    val email:String,
    val password:String,
    val fName:String,
    val lName:String,
    val uname:String,
    val gender:String,
    val bloodGroup:String,
    val age:Int,
    val address: Address
)
