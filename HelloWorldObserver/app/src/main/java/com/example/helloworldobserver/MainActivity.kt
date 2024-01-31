package com.example.helloworldobserver

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyObserver())
    }

    inner class MyObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreateEvent() {
            Log.d("MyObserver", "onCreate")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStartEvent() {
            Log.d("MyObserver", "onStart")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResumeEvent() {
            Log.d("MyObserver", "onResume")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onPauseEvent() {
            Log.d("MyObserver", "onPause")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStopEvent() {
            Log.d("MyObserver", "onStop")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroyEvent() {
            Log.d("MyObserver", "onDestroy")
        }
    }
}