package com.example.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView



class NewsFragment : Fragment() {


    private lateinit var recyclerView:RecyclerView
    private lateinit var newsAdapter:NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_news, container, false)

        recyclerView = view.findViewById(R.id.news_rv)
        newsAdapter = NewsAdapter(ArrayList())
        recyclerView.adapter = newsAdapter

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.articles.observe(viewLifecycleOwner, Observer {  articles ->
            articles?.let { newsAdapter.updateNewsList(it) }

        })



        return view
    }


}