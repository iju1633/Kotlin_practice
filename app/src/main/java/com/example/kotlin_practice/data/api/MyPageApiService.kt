package com.example.kotlin_practice.data.api

import com.example.kotlin_practice.data.model.mypage.DataModel
import retrofit2.Call
import retrofit2.http.GET


interface MyPageApiService {

    @GET("photos")
    fun getDataWithAPI() : Call<List<DataModel>>
}