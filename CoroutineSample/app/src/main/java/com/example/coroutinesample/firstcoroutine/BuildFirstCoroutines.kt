package com.example.coroutinesample.firstcoroutine


import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        delay(1000)
        println("Hello")
        delay(1000)
        println("World")
        println("Thread: ${Thread.currentThread().name}")
    }
    println("Done")
    println("Thread: ${Thread.currentThread().name}")
}