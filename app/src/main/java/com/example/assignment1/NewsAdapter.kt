package com.example.assignment1

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class NewsAdapter(private var newsList:List<ResponseModel.Article>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title:TextView = view.findViewById(R.id.title)
        val author:TextView = view.findViewById(R.id.author)
        val date:TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        val article = newsList[position]
        holder.title.text = article.title
        holder.author.text = article.author
        holder.date.text = article.publishedAt

        holder.itemView.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateNewsList(newNewsList: List<ResponseModel.Article>) {
        newsList = newNewsList
        notifyDataSetChanged()
    }

    private fun formatDate(dateStr: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val date = sdf.parse(dateStr) ?: return dateStr
        val outputFormat = SimpleDateFormat("dd MMM, yyyy hh:mm a", Locale.getDefault())
        return outputFormat.format(date)
    }



}