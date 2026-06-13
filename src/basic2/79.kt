package basic2

fun max(a: Int, b: Int) : Int {
    return if (a > b) a else b
}

fun main() {
    val max = max(10, 4)
    println(max)
}