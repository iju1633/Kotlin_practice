package com.example.kotlin_practice.data.api

import com.example.kotlin_practice.data.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RecyclerList>
}