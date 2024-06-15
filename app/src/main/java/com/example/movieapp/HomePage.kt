package com.example.movieapp

import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        // Find TabLayout and ViewPager2 by ID
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        // Apply padding for system bars (if needed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Example: Handle click on back button to go back to MainActivity
        findViewById<ImageView>(R.id.btn_back_to_main).setOnClickListener {
            onBackPressed()
        }

        // Initialize ViewPager2 and TabLayout
        val pagerAdapter = TabsPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Now Playing"
                1 -> "Popular"
                2 -> "Top Rated"
                3 -> "Upcoming"
                else -> ""
            }
        }.attach()
    }
}
