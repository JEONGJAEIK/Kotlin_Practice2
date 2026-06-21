package soksung.coroutineshard13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

suspend fun fetchUserData(): String {
    // 현재 스레드가 무엇이든 간에,
    // 이 블록 안에서는 Dispatchers.IO 스레드에서 실행됨을 보장받는다.
    val userName = withContext(Dispatchers.IO) {
        println("네트워크 요청 시작: ${Thread.currentThread().name}")
        delay(1000L) // 실제 네트워크 요청을 흉내
        "홍길동" // 이 값이 withContext의 반환 값이 됨
    }

    // withContext가 끝나면 원래 스레드로 돌아옴
    println("원래 스레드로 복귀: ${Thread.currentThread().name}")
    return userName
}

fun main() = runBlocking {
    println("작업 시작: ${Thread.currentThread().name}")
    val user = fetchUserData()
    println("획득한 사용자: $user")
}