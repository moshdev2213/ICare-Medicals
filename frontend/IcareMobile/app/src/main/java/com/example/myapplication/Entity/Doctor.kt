package com.example.myapplication.Entity

import java.io.Serializable

data class Doctor(
    var  email:String,
    var  firstName:String,
    var  lastName:String,
    var  timeAvailabe:String,
    var description:String,
    var specializing:String,
    var status:Int,
    var amount:Double,
    var cured:Int,
    var venue:String,
    var added:String
):Serializable
