package com.example.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NewsViewModel: ViewModel() {
    private val newsRepository = NewsRepository()
    val articles:LiveData<List<ResponseModel.Article>> = newsRepository.getArticles()
}