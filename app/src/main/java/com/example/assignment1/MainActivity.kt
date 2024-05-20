 package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class MainActivity : AppCompatActivity() {

     private lateinit var tabLayout:TabLayout
     private lateinit var viewPager:ViewPager2
     private lateinit var pagerAdapter:ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        pagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager){  tab, position ->

            tab.text = when(position){
                0 -> "Home"
                1 -> "News"
                else -> null
            }

        }.attach()



    }

}