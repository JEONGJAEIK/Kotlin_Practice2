package soksung

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.forEach({
        numbers -> println(numbers)
    })

    numbers.forEach { println(it) }

    val squaredNumbers = numbers.map { it * it }
    println(squaredNumbers)

    val name: String? = "Kotlin"

    name?.let {
        println("${it.length}")
        println("${it.uppercase()}")
    }
}