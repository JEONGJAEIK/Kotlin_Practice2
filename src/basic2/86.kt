package basic2//fun basic.main() {
//    val input = readln()
//    val name = if (input.isNotBlank()) input else "Kotlin"
//    println("Hello, $name!ddd")
//    println("\$x")
//}


fun main() {
    val name = readln()
    println("Hello, ${if (name.isBlank()) "someone" else name}!")
}