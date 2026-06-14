package soksung

// action 파라미터는 String을 받고 Unit을 반환하는 함수여야함
fun processString(str: String, action: (String) -> Unit) {
    action(str)
}

// language 파라미터에 따라 다른 종류의 인사말 생성 함수를 반환
fun getGreetingGenerator(language: String): (String) -> String {
    return when (language) {
        "ko" -> { name -> "안녕, $name"}
        "en" -> { name -> "Hello, $name"}
        else -> { name -> "Greetings, $name"}
    }
}

fun main() {
    processString("hello") {
        println(it.uppercase())
    }

    val koreanGreeter = getGreetingGenerator("ko")
    val englishGreeter = getGreetingGenerator("en")
    println(koreanGreeter("홍길동"))
    println(englishGreeter("Bob"))

    // Int 2개를 받아 Int만 반환하는 함수만 담을 수 있음
    val calculator: (Int, Int) -> Int
    calculator = {a, b -> a + b}
//    calculator = {str -> str.length} 컴파일 오류 함수 타입 일치 X

    var onEvent: (() -> Unit)? = null

    fun doSomething() {
        println("작업 수행중")
        // onEvent가 null이 아닐 경우에 함수를 호출(invoke)함
        onEvent?.invoke()
    }

    onEvent = {println("이벤트 발행")}
    doSomething()
}
