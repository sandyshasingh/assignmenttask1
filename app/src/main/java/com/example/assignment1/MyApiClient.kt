package com.example.assignment1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApiClient(private val apiKey: String) {

    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    suspend fun fetchData(): ResponseModel {
        return apiService.getTopHeadlines("google-news", apiKey)
    }
}