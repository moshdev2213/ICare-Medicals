package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Registration : AppCompatActivity() {
    private lateinit var btnSignUp:Button
    private lateinit var tvSignIn:TextView
    private lateinit var etRePassSignUp:EditText
    private lateinit var etPassSignUp:EditText
    private lateinit var etEmailSignUp:EditText
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}