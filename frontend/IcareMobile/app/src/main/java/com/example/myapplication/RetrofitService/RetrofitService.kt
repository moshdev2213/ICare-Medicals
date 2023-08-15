package com.example.myapplication.RetrofitService

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private var retrofit: Retrofit

    init {
        this.retrofit = initRetrofit()
    }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.12.145:8090")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
    fun getRetrofit() : Retrofit{
        return retrofit
    }
}