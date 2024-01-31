package com.example.coroutinecodelab

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//    DateTimeFormatter.ISO_LOCAL_TIME
//} else {
//    TODO("VERSION.SDK_INT < O")
//}
//val time = { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//    formatter.format(LocalDateTime.now())
//} else {
//    TODO("VERSION.SDK_INT < O")
//}
//}
//
//suspend fun getValue(): Double {
//    println("entering getValue() at ${time()}")
//    delay(3000)
//    println("leaving getValue() at ${time()}")
//    return Math.random()
//}


object Coroutine {
    fun main() {
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        repeat(3) {
            GlobalScope.launch {
                println("${Thread.currentThread()} has started")
                for (i in states) {
                    println("${Thread.currentThread()} - $i")
                }
            }
        }
    }

    fun main(){
        runBlocking {
            val num1 = async { getValue() }
            val num2 = async { getValue() }
            println("result of num1 + num2 is ${num1.await() + num2.await()}")
        }

        runBlocking {
            val num1 = getValue()
            val num2 = getValue()
            println("result of num1 + num2 is ${num1 + num2}")
        }

        repeat(3) {
            GlobalScope.launch {
                println("Hi from ${Thread.currentThread()}")
            }
        }
    }

    fun CoroutineScope.launch() {
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    }
}
