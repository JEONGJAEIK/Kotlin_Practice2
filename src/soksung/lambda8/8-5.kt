package soksung

inline fun runAndMeasure(block: () -> Unit) {
    println("시작")
    block()
    println("종료")
}

fun main() {
//    repeat(100) {
//        println("실행")
//    }

    runAndMeasure {
        println("핵심 로직 ㅜ행 중")
    }
}