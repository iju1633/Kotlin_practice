package com.example.kotlin_practice.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlin_practice.data.api.ImageApiService
import com.example.kotlin_practice.data.model.RecyclerData
import com.example.kotlin_practice.data.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ImageRepository @Inject constructor(private val retroInstance: ImageApiService) {

    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<RecyclerData>>) {
        val call: Call<RecyclerList> = retroInstance.getDataFromAPI(query)
        call?.enqueue(object : Callback<RecyclerList>{
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items!!)
            }
        })

    }
}