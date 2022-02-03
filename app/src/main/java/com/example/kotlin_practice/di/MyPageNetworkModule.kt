package com.example.kotlin_practice.di

import com.example.kotlin_practice.BuildConfig
import com.example.kotlin_practice.data.api.MyPageApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MyPageNetworkModule {

    @Singleton
    @Provides
    fun getRetroInstance() : MyPageApiService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyPageApiService::class.java)
}

