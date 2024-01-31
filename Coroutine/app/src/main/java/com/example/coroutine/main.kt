package com.example.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

//suspend fun doSomethingFunny1(): Int{
//    delay(1000)
//    return 10
//}
//suspend fun doSomethingFunny2(): Int{
//    delay(1000)
//    return 20
//}

//fun foo(n:Int): Sequence<Int> = sequence{
//    for (i in 0..n){
//        if (i%2 == 0) yield(i)
//    }
//}

fun foo(n:Int) : Flow<Int> = flow {
    for (i in 0..n){
        delay(1000)
        emit(i)
    }
}

fun main(){

    runBlocking {
        val foo = foo(200)
        foo(5).collect {
            println("i = $it")
        }
    }

//    foo(10).filter { it < 8 }.forEach {
//        println(it)
//    }

//    foo(10).map {it*it }.forEach {
//        println(it)
//    }

//    foo(10).forEach {
//        println(it)
//    }

//    runBlocking {
//        supervisorScope {
//            val firstChild = launch {
//                println("Print from First Child")
//                throw NullPointerException()
//            }
//            val secondChild = launch {
//                firstChild.join()
//                println("print from second Child. First Child is Active:${firstChild.isActive}")
//                try {
//                    delay(1000)
//                } finally {
//                    println("Second Child Cancelled")
//                }
//            }
//            firstChild.join()
//            secondChild.join()
//        }
//    }

//    runBlocking {
//        val supervisorJob = SupervisorJob()
//        with(CoroutineScope(coroutineContext + supervisorJob)){
//            val firstChild = launch {
//                println("Print from first child")
//                throw NullPointerException()
//            }
//            val secondChild = launch {
//                firstChild.join()
//                println("print from second Child. First Child is Active: ${firstChild.isActive}")
//                try {
//                    delay(1000)
//                } finally {
//                    println("Second Child Cancelled")
//                }
//            }
//            firstChild.join()
//            println("Cancelling SupervisorJob")
//            supervisorJob.cancel()
//            secondChild.join()
//        }
//
//    }

//    runBlocking {
//        val handler = CoroutineExceptionHandler{
//                _,exception -> println("Exception: $exception with suppressed ${exception.suppressed.contentToString()}")
//        }
//        val job = GlobalScope.launch(handler) {
//            launch {
//                println("Coroutine 1")
//                delay(300)
//                println("Coroutine 1 continue")
//                throw IndexOutOfBoundsException()
//            }
//            launch {
//                try {
//                    delay(Long.MAX_VALUE)
//                } finally {
//                    throw ArithmeticException("Coroutine 2")
//                }
//                launch {
//                    println("Coroutine 3")
//                    delay(400)
//                    println("Coroutine 3 continue")
//                    throw ArithmeticException("Coroutine 3")
//                }
//            }
//        }
//        job.join()
//        delay(1000)
//    }

//    runBlocking {
//        val handler = CoroutineExceptionHandler{
//                _,exception -> println("Exception: $exception ")
//        }
//        val job = GlobalScope.launch(handler) {
//            launch {
//                println("Coroutine 1")
//                delay(300)
//                println("Coroutine 1 continue")
//                throw IndexOutOfBoundsException()
//            }
//            launch {
//                println("Coroutine 2")
//                delay(200)
//                throw NullPointerException("Coroutine 2")
//                launch {
//                    println("Coroutine 3")
//                    delay(400)
//                    println("Coroutine 3 continue")
//                    throw ArithmeticException("Coroutine 3")
//                }
//            }
//        }
//        job.join()
//        delay(1000)
//    }

//    runBlocking {
//        val handler = CoroutineExceptionHandler{
//                _,exception -> println("Error here: ${exception.toString()}")
//        }
//        val job = GlobalScope.launch(handler + Dispatchers.Default) {
//            try {
//                println("Throw Exception from launch")
//                throw NullPointerException()
//            } catch (e:NullPointerException){
//                println(e.toString())
//            }
//        }
//        job.join()
//        val deffered = GlobalScope.async(handler) {
//            println("Throw exception from async")
//            throw IndexOutOfBoundsException()
//        }
//        deffered.await()
//    }

//    runBlocking {
//        val handler = CoroutineExceptionHandler{
//            _,exception -> println("Error here: ${exception.toString()}")
//        }
//        val job = GlobalScope.launch(handler + Dispatchers.Default) {
//            try {
//                println("Throw Exception from launch")
//                throw NullPointerException()
//            } catch (e:NullPointerException){
//                println(e.toString())
//            }
//        }
//        job.join()
//        val deffered = GlobalScope.async {
//            println("Throw exception from async")
//            throw IndexOutOfBoundsException()
//        }
//        try {
//            deffered.await()
//        }catch (e: IndexOutOfBoundsException){
//            println(e.toString())
//        }
//    }

//    runBlocking {
//        val job = GlobalScope.launch {
//            println("Throw Exception from launch")
//            throw NullPointerException()
//        }
//        job.join()
//        val deffered = GlobalScope.async {
//            println("Throw exception from async")
//            throw IndexOutOfBoundsException()
//        }
//        deffered.await()
//    }

//    runBlocking {
//        val job = launch {
//            repeat(3){
//                launch {
//                    delay(100)
//                    println("coroutine: $it")
//                }
//            }
//            println("Print from parent")
//        }
//        job.join()
//        delay(1000)
//    }

//    runBlocking {
//        val job1: Job = GlobalScope.launch {
//            launch {
//                delay(100)
//                println("coroutine 1: Hello")
//                delay(1000)
//                println("coroutine 1: Goodbye")
//            }
//            launch {
//                delay(100)
//                println("coroutine 2: Hello")
//                delay(1000)
//                println("coroutine 2: Goodbye")
//            }
//            GlobalScope.launch {
//                delay(100)
//                println("coroutine 3: Hello")
//                delay(1000)
//                println("coroutine 3: Goodbye")
//            }
//        }
//        delay(500)
//        job1.cancel()
//        delay(2500)
//    }


//    runBlocking {
//        val time = measureTimeMillis {
//            val a: Deferred<Int> = async { doSomethingFunny1() }
//            val b: Deferred<Int> = async { doSomethingFunny2() }
//            println("a + b = ${a.await() + b.await()}")
//        }
//        println("Time = $time")
//    }

//    runBlocking {
//        val result =  withTimeoutOrNull(1800){
//            repeat(2){
//                println("$it")
//                delay(500)
//            }
//            "Done"
//        }
//        println("${result}")
//    }

//    runBlocking {
//        val job: Job = GlobalScope.launch {
//            try {
//                repeat(1000){
//                    delay(100)
//                    println("Hello Coroutine")
//                }
//            } finally {
//                println("Print from finally")
////                delay(100)
////                println("Please print me last times")
//                withContext(NonCancellable){
//                    repeat(2){
//                        delay(100)
//                        println("Print from NonCancel")
//                    }
//                }
//            }
//        }
//        delay(300)
//        println("I want to stop coroutine")
//        job.cancel()
//    }

//    runBlocking {
//        val startTime = System.currentTimeMillis()
//        val job: Job=GlobalScope.launch(Dispatchers.Default) {
//            var nextPrintTime = startTime
//            var i = 0
//            while (isActive && i<5) {
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
//
//    }


//    val job1: Job = GlobalScope.launch {
//        delay(2000)
//        println("Hello Kotlin")
//    }
//    val job2: Job = GlobalScope.launch {
//        job1.join()
//        delay(1000)
//        println("I'm Coroutine")
//    }
//    Thread.sleep(4000)

//    val job: Job = GlobalScope.launch(Dispatchers.Default){
//        repeat(1000){
//            delay(500)
//            println("I'm sleep $it")
//        }
//    }
//    delay(1500)
//    job.cancel()
//    println("Cancelled")
}