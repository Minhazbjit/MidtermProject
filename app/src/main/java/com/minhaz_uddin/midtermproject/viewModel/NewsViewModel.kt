package com.minhaz_uddin.midtermproject.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minhaz_uddin.midtermproject.NewsDatabase.NewsDatabase
import com.minhaz_uddin.midtermproject.model.Article
import com.minhaz_uddin.midtermproject.model.CustomArticles
import com.minhaz_uddin.midtermproject.model.NewsData
import com.minhaz_uddin.midtermproject.network.NewsApi
import com.minhaz_uddin.midtermproject.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _newsList = MutableLiveData<List<Article>>()
    private val _newsList2 = MutableLiveData<List<Article>>()
    val newsList = _newsList
    val newsList2 = _newsList2
    val newsRepository: Repository


    init {
        val newsDao = NewsDatabase.getDatabaseInstance(application).newsDao()
        newsRepository = Repository(newsDao)
        getNews()
        getScienceNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            _newsList.value = NewsApi.retrofitService.getNews().articles
            Log.d("TAG", "getNews: ${_newsList.value!!}")

        }
    }

    private fun getScienceNews() {
        viewModelScope.launch {
            _newsList2.value = NewsApi.retrofitService.getScienceNews().articles
            articleToCustom("Science", _newsList2)


        }
    }

    fun articleToCustom(category: String, articlesList: MutableLiveData<List<Article>>) {
        if(articlesList.value != null) {
            for (news in articlesList.value!!) {
                val articles = CustomArticles(
                    news.author, news.content, category,
                    news.description, news.publishedAt, news.title, news.url, news.urlToImage
                )
                addArticle(articles)
            }

        }

    }

    fun addArticle(articles: CustomArticles) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.addNewsArticle(articles)
        }

    }


}