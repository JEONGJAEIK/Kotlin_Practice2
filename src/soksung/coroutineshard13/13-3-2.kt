package soksung.coroutineshard13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main() = runBlocking {
    val job = launch {
        println("부모 코루틴 시작")
        withContext(Dispatchers.Default) {
            println("withContext 블록 시작")
            delay(2000L) // 이 작업은 완료되지 못함
            println("withContext 블록 종료")
        }
        println("부모 코루틴 종료")
    }
    delay(1000L)
    job.cancelAndJoin() // 1초 후 부모 코루틴을 취소
    println("취소 완료")
}