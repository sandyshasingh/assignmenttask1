package com.example.assignment1

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(var activity: AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> NewsFragment()
            else -> { throw IllegalStateException("Unexpected position: $position")
            }
        }
    }


}
