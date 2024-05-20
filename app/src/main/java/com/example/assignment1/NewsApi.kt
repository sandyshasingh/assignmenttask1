package com.example.assignment1


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): Call<ResponseModel>
}