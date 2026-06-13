package function3

fun main() {
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = listOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    val strings = listOf("first", "second", "fourteenth")
    val numbers = setOf(1, 14, 2)

    println(strings.last())
    println(strings.shuffled())
    println(numbers.sum())

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}


