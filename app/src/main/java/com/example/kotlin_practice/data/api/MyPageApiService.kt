package com.example.kotlin_practice.data.api

import com.example.kotlin_practice.data.model.mypage.tree.TreeModelItemList
import com.example.kotlin_practice.data.model.mypage.user.UserModel
import retrofit2.Call
import retrofit2.http.GET


interface MyPageApiService {
    // 스웨거 참고하여 코드 짤 것

    // mypage 의 textview 에 들어갈 데이터
    @GET("users/1/")
    fun getUserData() : Call<UserModel>

    // recyclerview 에 들어갈 데이터
    @GET("users/1/trees/")
    fun getTreeData() : Call<TreeModelItemList>

}