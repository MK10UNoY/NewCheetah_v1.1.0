package com.infomanix.newcheetah_v110

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsAppViewModel: ViewModel() {
    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>> =_news

    init{
        fetchNews()
    }
    private fun fetchNews() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTopHeadlines("us",New)
                _news.value = response.articles
            } catch (e: Exception) {
                // Handle errors
            }
        }
    }
}