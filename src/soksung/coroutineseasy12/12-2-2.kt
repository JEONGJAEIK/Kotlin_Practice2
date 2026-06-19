package soksung.coroutineseasy12

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun fetchUser(id: String) : String {
    delay(1000L)
    return "User($id)"
}

fun main() = runBlocking {
    val deferredUser: Deferred<String> = GlobalScope.async {
        fetchUser("user123")
    }

    println("사용자 정보를 기다리는 동안 다른 작업을 한다")

    // deferredUser의 결과가 준비될 때까지 코루틴 일시 중단하고 기다림
    val user: String = deferredUser.await()
    println(user)
}