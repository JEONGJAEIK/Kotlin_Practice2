package basic

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "피즈버즈"
    i % 3 == 0 -> "피즈"
    i % 5 == 0 -> "버즈"
    else -> "$i"
}

fun main() {
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
}