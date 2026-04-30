package com.example.myapplication.di

import com.example.myapplication.data.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteModule {

    fun provideBaseUrl(): String {
        return "https://petapi-591531460223.us-central1.run.app/api/"
    }

    fun provideRetrofit(baseUrl: String = provideBaseUrl()): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideProductService(retrofit: Retrofit = provideRetrofit()): ProductService {
        return retrofit.create(ProductService::class.java)
    }
}