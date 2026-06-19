package soksung.coroutineseasy12

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // GlobalScope는 애플리케이션 전체 생명주기를 가지는 코루틴 스코프다 (연습용으로만 써야함)
    GlobalScope.launch {
        println("코루틴 시작")
        delay(1000L)
        println("World")
    }

    println("Hello,") // launch 블록 밖의 코드는 바로 실행
    Thread.sleep(2000L) // 메인 스레드 2초 대기 (코루틴 끝날 시간 범)
    println("메인 스레드 종료")
}