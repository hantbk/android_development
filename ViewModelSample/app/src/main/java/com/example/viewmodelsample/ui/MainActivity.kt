package com.example.viewmodelsample.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelsample.R
import com.example.viewmodelsample.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
    var mCounterViewModel: CounterViewModel? = null
    var tvCount = findViewById<TextView>(R.id.tvCount)
    var btnUp = findViewById<ImageButton>(R.id.btnUp)
    var btnDown = findViewById<ImageButton>(R.id.btnDown)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCounterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        displayCount()
        btnUp.setOnClickListener { v -> onClick(v) }
        btnDown.setOnClickListener { v -> onClick(v) }
    }

    
    fun displayCount() {
        tvCount.text = mCounterViewModel?.count.toString()
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnUp -> {
                mCounterViewModel?.count = mCounterViewModel?.count!! + 1
                displayCount()
            }
            R.id.btnDown -> {
                mCounterViewModel?.count = mCounterViewModel?.count!! - 1
                displayCount()
            }
        }
    }
}