package soksung

fun main() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5) // 중복 허용
    println(numbers[0])
    println(numbers.size)

    val mutableNumbers: MutableList<Int> = mutableListOf(1, 2, 3)
    println(mutableNumbers)

    mutableNumbers.add(4)
    mutableNumbers.removeAt(0)
    mutableNumbers[1] = 100
    println(mutableNumbers)

    val fruits: Set<String> = setOf("사과", "바나나", "오렌지", "바나나")
    println(fruits)

    val mutableFruits: MutableSet<String> = mutableSetOf("사과")
    mutableFruits.add("바나나")
    mutableFruits.add("사과")
    println(mutableFruits)

    val userAges: Map<String, Int> = mapOf(
        "Alice" to 30,
        "Bob" to 25
    )

    println(userAges["Alice"])
//    userAges["dd"] = 4 컴파일 오류 읽기 전용

    val mutableUserAges: MutableMap<String, Int> = mutableMapOf("Alice" to 30)
    mutableUserAges["Bob"] = 25
    mutableUserAges["Alice"] = 31
    mutableUserAges.remove("Bob")
    println(mutableUserAges)

}
