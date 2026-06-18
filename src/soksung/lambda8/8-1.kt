package soksung

// block이라는 이름의 파라미터로, 파라미터도 없고 반환도 없는 함수(() -> Unit)를 받는다.
fun measureExecutionTime(block: () -> Unit) {
    val startTime = System.nanoTime()
    block() // 전달받은 함수를 여기서 실행
    val endTime = System.nanoTime()
    val elapsedTime = (endTime - startTime) / 1_000_000.0
    println("실행 시간: ${elapsedTime}ms")
}

// factor를 인자로 받아, (Int) -> Int 타입의 함수를 반환한다.
fun getMultiplier(factor: Int): (Int) -> Int {
    // 람다를 반환한다. 이 람다는 외부의 factor 변수를 기억한다(클로저)
    return {number -> number * factor}
}

fun main() {
    measureExecutionTime {
        // 측정하고 싶은 코드 람다로 전달
        var sum = 0L
        for (i in 1..1_000_000_000) {
            sum += i
        }
    }

    measureExecutionTime {
        Thread.sleep(1200)
    }

    // 2를 곱하는 함수 생성
    val double: (Int) -> Int = getMultiplier(2)

    // 3를 곱하는 함수 생성
    val triple = getMultiplier(3)

    println(double(10)) // 20
    println(double(25)) // 50

    println(triple(10)) // 30
    println(triple(25)) // 75
}
