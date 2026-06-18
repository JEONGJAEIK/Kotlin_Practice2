package soksung

fun getMultiplier2(factor: Int): (Int) -> Int {
    // 1. 람다가 정의되는 순간, 자신의 본문 {number -> number * factor}을 살펴봄
    // 2. 본문이 외부 스코프에 있는 factor 변수를 사용한다는 것을 인지
    // 3. 람다는 이 factor 변수를 자신의 가방 (클로저) 속에 포획
    return {number -> number * factor}
}

fun makeCounter(): () -> Int {
    // 'count'는 makeCounter 함수의 지역 변수이다.
    var count = 0

    // 반환되는 람다는 이 'count' 변수를 포획한다.
    return {
        count++ // 람다 내부에서 외부 변수 count를 수정한다.
        count   // 수정된 값을 반환한다.
    }
}

fun main() {
    val counter1 = makeCounter()
    println(counter1())
    println(counter1())
    println(counter1())

    // counter2는 counter1과 완전히 독립적인 자신만의 count 변수를 포획한다.
    val counter2 = makeCounter()
    println(counter2())
    println(counter2())
    println(counter2())

    println(counter1()) // (counter1의 count는 계속 유지된다.)


    // getMultiplier2(2)가 호출되면 factor = 2를 포획한 람다가 생성되어 double 변수에 할당
    val double: (Int) -> Int = getMultiplier2(2)

    // getMultiplier2(3)이 호출되면 factor = 3를 포획한 또 다른 람다가 생성되어 triple 변수에 할당
    val triple = getMultiplier2(3)

    // getMultiplier2는 실행이 끝났지만 double 람다는 자신이 포확한 factor = 2를 여전히 기억함
    println(double(10)) // 20
    println(double(25)) // 50

    // triple 람다도 자신이 포확한 factor = 3를 여전히 기억함
    println(triple(10)) // 30
    println(triple(25)) // 75
}