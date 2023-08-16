package com.example.myapplication.EntityDao

data class EyeScanDao(
    val id: String,
    val project: String,
    val iteration: String,
    val created: String,
    val predictions: Array<Prediction>
){
    data class Prediction(
        val probability: String,
        val tagId: String,
        val tagName: String
    )
}
