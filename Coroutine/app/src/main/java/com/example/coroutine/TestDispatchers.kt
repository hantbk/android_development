package com.example.coroutine

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object TestDispatchers {
    fun runMyFirstCoroutines(){
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(MainActivity::class.java.simpleName,"Before delay Dispatcher Unconfined run on ${Thread.currentThread().name}")
            delay(1000)
            Log.d(MainActivity::class.java.simpleName,"Dispatcher Unconfined run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(MainActivity::class.java.simpleName,"Dispatcher Main run on ${Thread.currentThread().name}")
        }
    }

    fun testMySecondWithContext(){
        var a:Int = 10
        GlobalScope.launch(Dispatchers.Main) {
            Log.d("myLog", "Run long time task - Thread: ${Thread.currentThread().name}")
            delay(2000)
            a +=20
            withContext(Dispatchers.Main){
                Log.d("myLog", "Update UI - Thread: ${Thread.currentThread().name} a=$a")
            }
        }
    }

    fun main(){
        val job1: Job = GlobalScope.launch {
            delay(2000)
            println("Hello Kotlin")
        }
        val job2: Job = GlobalScope.launch {
            job1.join()
            delay(1000)
            println("I'm Coroutine")
        }
        Thread.sleep(4000)
    }
}