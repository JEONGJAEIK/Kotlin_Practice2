package soksung

import java.util.Timer
import java.util.TimerTask

// 이 함수는 inline 함수가 아니라서 파라미터로 함수 객체를 받는다
fun logAndExecute(task: () -> Unit) {
    println("로깅")
    task()
}

// execute 함수는 inline이지만, logTask 파라미터는 noinline으로 지정
inline fun execute(
    mainTask: () -> Unit,
    noinline logTask: () -> Unit
) {
    println("메인 작업 시작")
    mainTask() // mainTask의 본문은 이곳에 복사됨 (인라인)

    // logTask는 noinline이므로, 객체로 취급되어 다른 함수에 전달 가능
    logAndExecute(logTask)
}

inline fun runWithDelayStart(crossinline block: () -> Unit) {
    println("3초 뒤 작업 시작")

    // block 람다가 즉시 실행되지 않고, Timer의 콜백(다른 실행 컨텍스트)에서 실행됨
    Timer().schedule(object : TimerTask() {
        override fun run() {
            block()
        }
    }, 3000L)
}

fun main() {
    execute(
        mainTask = {
            println("핵심 로직 수행")
        },
        logTask = {
            println("이 작업은 로그로 남겨야 해")
        }
    )

    runWithDelayStart {
        println("작업 실행")
        // return // 컴파일 오류 crossinline 람다에서는 비지역 변환을 할 수 없다
    }
    println("main 함수는 계속 진행된다...")
}