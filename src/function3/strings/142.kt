package function3.strings

fun String.lastChar(): Char = this.get(length - 1)

fun main() {
    val lastChar = "Kotlin".lastChar()
    println(lastChar)
}