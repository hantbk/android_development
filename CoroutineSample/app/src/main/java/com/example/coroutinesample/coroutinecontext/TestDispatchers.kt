package com.example.coroutinesample.coroutinecontext

import android.util.Log
import com.example.coroutinesample.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(MainActivity::class.java.simpleName,"Dispatcher IO run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Default) {
            Log.d(MainActivity::class.java.simpleName,"Dispatcher Default run on ${Thread.currentThread().name}")
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

    fun main1(){
        runBlocking {
            val job = GlobalScope.launch(Dispatchers.Default) {
                repeat(1000){
                    delay(500)
                    println("I'm sleeping $it...")
                }
            }
            delay(1500)
            job.cancel()
            println("Done")
        }
    }
}