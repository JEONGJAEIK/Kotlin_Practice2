package soksung.coroutineseasy12

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun calculateResult(): Int {
    delay(1000L)
    return 42
}

fun main() = runBlocking {
    val deferred: Deferred<Int> = async {
        calculateResult()
    }

    println("계산이 진행되는 동안 다른 작업을 할 수 있다.")

    // await를 호출하여 결과가 준비될 때까지 기다린다.
    val result = deferred.await()
    println("계산 결과: $result")

    // Deferred는 Job이므로 취소도 가능하다
    // deferred.cancel()
}