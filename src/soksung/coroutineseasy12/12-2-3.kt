package soksung.coroutineseasy12

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello, ")

    // main함수를 runBlocking으로 감싸면 더 이상 Thread.sleep이 필요없음
    // runBlocking이 내부의 launch 코루틴이 끝날 때까지 스레드를 기다려줌
}