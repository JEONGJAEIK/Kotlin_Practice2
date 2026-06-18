package soksung

// 수신객체타입.함수이름
fun String.lastChar(): Char {
    // 확장 함수 본문 안에서 this란 수신 객체, 즉 함수를 호출한 String 객체 자체를 가리킨다.
    return this[this.length - 1]
}

fun main() {
    val message = "Hello, Kotlin!"
    val lastChar = message.lastChar()
    println("'$message'의 마지막 문자는 '$lastChar'이다.")
}