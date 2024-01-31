package com.example.coroutinesample


import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun foo(n:Int) : Flow<Int> = flow {
    for (i in 0..n){
        delay(1000)
        emit(i)
    }
}

fun main() {
    runBlocking {
        val foo = foo(200)
        foo(5).collect {
            println("i = $it")
        }
    }

//        runBlocking {
//            val result =  withTimeoutOrNull(1800){
//                repeat(1000){
//                    println("I'm sleeping $it...")
//                    delay(500)
//                }
//                "Done"
//            }
//            println("${result}")
//    }

//    runBlocking {
//        val job = launch(Dispatchers.Default){
//            repeat(1000){
//                delay(500)
//                println("I'm sleeping $it...")
//            }
//        }
//        delay(1500)
//        job.cancel()
//        println("Done")
//    }

//        runBlocking {
//        val startTime = System.currentTimeMillis()
//        val job: Job = GlobalScope.launch(Dispatchers.Default) {
//            var nextPrintTime = startTime
//            var i = 0
//            while (isActive) {
//                if(System.currentTimeMillis() >= nextPrintTime){
//                    println("job: I'm sleeping ${i++}...")
//                    nextPrintTime+=500
//                }
//            }
//        }
//
//        delay(1400)
//        println("main: I'm tired of waiting")
//        job.cancelAndJoin()
////        job.cancel()
//        println("main: Now I can quit")
//    }
}