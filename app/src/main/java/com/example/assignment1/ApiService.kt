package com.example.assignment1


import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): ResponseModel
}