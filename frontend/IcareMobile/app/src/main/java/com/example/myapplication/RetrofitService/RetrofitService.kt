package com.example.myapplication.RetrofitService

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {
    private var retrofit: Retrofit

    init {
        this.retrofit = initRetrofit()
    }

    private fun initRetrofit(): Retrofit {
        // Create a custom OkHttpClient with extended timeout settings
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS) // Set the connection timeout to 30 seconds
            .readTimeout(30, TimeUnit.SECONDS)    // Set the read timeout to 30 seconds
            .writeTimeout(30, TimeUnit.SECONDS)   // Set the write timeout to 30 seconds
            .build()

        return Retrofit.Builder()
            .baseUrl("http://172.20.10.11:8090")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
    }
    fun getRetrofit() : Retrofit{
        return retrofit
    }
}