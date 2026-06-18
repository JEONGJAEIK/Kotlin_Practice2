package soksung.function4.soksung2

import soksung.isAllUpperCase

// 파일 B
fun main() {
    val text1 = "HELLO"
    val text2 = "hello"

    println("$text1 is all upper case? ${isAllUpperCase(text1)}")
    println("$text2 is all upper case? ${isAllUpperCase(text2)}")
}