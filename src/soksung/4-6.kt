package soksung

// String 클래스에 대한 확장 함수다 앞에 infix 붙임
infix fun String.beginWith(prefix: String): Boolean {
    return this.startsWith(prefix)
}

fun main() {
    val message = "Hello Kotlin"

    // 중위 표기법으로 함수 호출
    val result1 = message beginWith "Hello"
    println(result1)

    // 기존 방식도 가능하다
    val result2 = message.beginWith("Kotlin")
    println(result2)

    val capitals = mapOf("대한민국" to "서울")
    for (i in 10 downTo 1) {
        //...
    }
    val result = 10 and 12


}