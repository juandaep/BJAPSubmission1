package com.example.bjapsubmission1.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bjapsubmission1.R
import com.example.bjapsubmission1.ui.home.content.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Movie App"
        supportActionBar?.elevation = 0f

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        view_pager.adapter = pagerAdapter
        tab_layout.setupWithViewPager(view_pager)
    }
}