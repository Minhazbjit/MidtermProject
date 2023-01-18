package com.minhaz_uddin.midtermproject.adapter

import android.annotation.SuppressLint
import android.app.ActivityManager.RecentTaskInfo
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minhaz_uddin.midtermproject.R
import com.minhaz_uddin.midtermproject.model.Article
import com.minhaz_uddin.midtermproject.viewModel.NewsViewModel


class NewsAdapter(private val context:Context,private val viewModel: NewsViewModel,private val newsList:List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val title=view.findViewById<TextView>(R.id.title)
        val description=view.findViewById<TextView>(R.id.description)
        val author=view.findViewById<TextView>(R.id.author)
        val pub_date=view.findViewById<TextView>(R.id.date_publish)
        val newsImage=view.findViewById<ImageView>(R.id.news_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
      Log.d("Ada","Adapter_created")
      val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.news_list,parent,false)
      return NewsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=newsList[position]
        holder.author.text=news.author
        holder.description.text=news.description
        holder.title.text=news.title
        holder.pub_date.text=news.publishedAt
        Glide.with(context)
            .load(news.urlToImage)
            .centerCrop()
            .into(holder.newsImage)


    }

    override fun getItemCount(): Int {
      return newsList.size
    }
}