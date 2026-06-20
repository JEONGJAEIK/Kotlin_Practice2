package soksung.coroutineshard13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val job = launch {
        repeat(100) { i ->
            println("반복 작업 중 $i")
            delay(500L) // 이 함수가 취소 요청을 확인하는 협력 지점이 됨
        }
    }
    delay(1200L)
    job.cancel()

    // 이 코드는 delay()가 없어서 취소되지 않고 5초 동안 계속 실행됨
    val job2 = launch(Dispatchers.Default) {
        var i = 0
        while (i < 5) {
            // CPU만 사용하는 복잡한 작업 스레드슬립은 코루틴 취소와 무관
            Thread.sleep(1000L)
            i++
            println("작업 진행 중... $i")
        }
    }

    delay(2500L) // 2.5초 뒤에 취소 요청을 보내지만..
    job2.cancel()
    job2.join()
    println("작업 종료")

    val job3 = launch(Dispatchers.Default){
        var i = 0
        // while 문의 조건으로 isActive 직접 확인
        while (i < 5 && isActive) {
            Thread.sleep(1000L)
            i++
            println("작업 진행 중... $i")
        }
    }

    delay(2500L)
    job3.cancel()
    job3.join()
    println("작업 종료")

    val job4 = launch {
        try {
            println("리소스 획득")
            repeat(1000) { i ->
                println("작업 중 $i")
                delay(500L)
            }
        } finally {
            // 이 블록은 코루틴이 취소될 때 반드시 실행됨
            println("리소스 정리 완료")
        }
    }

    delay(1300L)
    job4.cancelAndJoin() // cancel과 join을 한번에 호출
    println("메인: 코루틴 취소 완료")
}

