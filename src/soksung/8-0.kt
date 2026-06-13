package soksung

// 변수 sum은 (Int, Int) -> Int 라는 함수 타입을 가짐
val sum: (Int, Int) -> Int = {a: Int, b: Int -> a + b}

// 익명 함수
// 람다와의 차이는 return의 동작, 람다에서 return은 람다를 감싸고 있는 가장 가까운 함수를 빠져나가지만 익명 함수에서 return은 익명 함수 자체만 빠져나간다.
// 대부분의 경우 람다의 간결함이 선호되지만, return 동작을 명확히 제어하고 싶을 때 익명 함수가 사용될 수 있다.

val sum2 = fun(a: Int, b: Int): Int {
    return a + b
}

// operation이라는 이름의 함수를 파라미터로 받는 고차 함수
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    // 덧셈 람다 전달
    val sumResult = calculate(10, 5, {a, b -> a + b})
    println(sumResult)

    // 뺄셈 람다 전달
    val subtractResult = calculate(10, 5, {a, b -> a - b})
    println(subtractResult)

    // 후행 람다 변환
    // 함수의 마지막 파라미터가 람다 표현식이라면 그 람다를 함수 호출 괄호 밖으로 빼낼 수 있음
    val subtractResult2 = calculate(10, 5) {a, b -> a - b}
    println(subtractResult2)




}
