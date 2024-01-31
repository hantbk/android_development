package com.example.coroutinesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinesample.coroutinecontext.TestDispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TestDispatchers.main1()
    }
}