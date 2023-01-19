package com.minhaz_uddin.midtermproject.repository

import androidx.lifecycle.LiveData
import com.minhaz_uddin.midtermproject.model.CustomArticles
import com.minhaz_uddin.midtermproject.newsDao.NewsDao

class Repository(private val newsDao: NewsDao) {

    suspend fun addNewsArticle(articles: CustomArticles) {
        newsDao.addNewsArticle(articles)
    }

    suspend fun deleteAllNews() {
        newsDao.deleteAllArticles()
    }

    suspend fun readAllArticles(): List<CustomArticles> {
        return newsDao.readAllArticles()
    }


}