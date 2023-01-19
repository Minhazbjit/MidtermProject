package com.minhaz_uddin.midtermproject.network

import com.minhaz_uddin.midtermproject.model.Article
import com.minhaz_uddin.midtermproject.model.NewsData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL="https://newsapi.org/v2/"

private val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit=Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()


interface NewsApiService{
    @GET("everything?q=*&apiKey=b39cc78356be4d04a705d42960788212")
    suspend fun getNews():NewsData
    @GET("top-headlines?country=us&category=science&apiKey=b39cc78356be4d04a705d42960788212")
    suspend fun getScienceNews():NewsData
}

object NewsApi{
    val retrofitService:NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}