package com.minhaz_uddin.midtermproject.newsDao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minhaz_uddin.midtermproject.model.Article
import com.minhaz_uddin.midtermproject.model.CustomArticles

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewsArticle(article: CustomArticles)

    @Query ("SELECT * FROM articlesDB")
    suspend fun readAllArticles(): List<CustomArticles>

    @Query("DELETE  FROM articlesDB")
    suspend fun deleteAllArticles()

}