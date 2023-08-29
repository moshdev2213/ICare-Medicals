package com.example.myapplication.APIServices

import com.example.myapplication.EntityDao.EyeScanDao
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface EyeScanAPI {
    @Multipart
    @POST("/api/scan/eye")
    fun eyeScanPredict(@Part image: MultipartBody.Part): Call<EyeScanDao>
}