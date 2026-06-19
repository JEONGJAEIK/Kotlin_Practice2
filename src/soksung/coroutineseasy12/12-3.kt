package soksung.coroutineseasy12

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job: Job = launch {
        try {
            repeat(1000) { i ->
                println("Job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("Job: I'm running in finally!")
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel() // 코루틴 취소
    job.join() // 코루틴이 완전히 취소될 때 까지 기다림
    println("main: Now I can quit.")
}