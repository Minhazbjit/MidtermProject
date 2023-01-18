package com.minhaz_uddin.midtermproject.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.minhaz_uddin.midtermproject.model.Article
import com.minhaz_uddin.midtermproject.model.NewsData
import com.minhaz_uddin.midtermproject.network.NewsApi
import kotlinx.coroutines.launch


class NewsViewModel:ViewModel() {
    private val _newsList=MutableLiveData<NewsData>()
    val newsList=_newsList

    init{
        getNews()
    }

   private fun getNews(){
      viewModelScope.launch {
          _newsList.value=NewsApi.retrofitService.getNews()
          Log.d("TAG", "getNews: ${_newsList.value!!.articles}")

      }

   }

}