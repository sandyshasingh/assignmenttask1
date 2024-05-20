package com.example.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository() {

    private val newsApi: NewsApi
    private val BASE_URL = "https://newsapi.org/v2/"
    val apiKey = "3d4b58cf626544e18ce0417958e99817"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsApi = retrofit.create(NewsApi::class.java)
    }

    fun getArticles():LiveData<List<ResponseModel.Article>>{

        val articlesData = MutableLiveData<List<ResponseModel.Article>>()
        newsApi.getTopHeadlines("google-news",apiKey).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call:Call<ResponseModel>,response: Response<ResponseModel>){
                if(response.isSuccessful && response.body() !=null){
                    articlesData.value = response.body()?.articles
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                articlesData.value = null
            }
        })
        return articlesData

    }

//    suspend fun fetchData(): ResponseModel {
//        return apiService.getTopHeadlines("google-news", apiKey)
//    }
}