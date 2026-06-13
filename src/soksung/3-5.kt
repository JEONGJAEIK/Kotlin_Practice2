package soksung

fun main() {
    val favoriteFruits = listOf("사과", "딸기", "망고")
    val hasStrawberry = "딸기" in favoriteFruits
    println("딸기 조아? $hasStrawberry")

    val hasGrape = "포도" in favoriteFruits
    println("포도 조아? $hasGrape")

    val userAge = 35

    if (userAge in 30..39) {
        println("30대")
    }

    val examScore = 75
    if (examScore in 0 until 80) {
        println("보충 ㄱ")
    }

    val guestCount = 12
    val allowedRange = 1..10

    if (guestCount !in allowedRange) {
        println("ㅌㅌ")
    }

    val bannedUsers = setOf("spammer1", "troll2")
    val currentUser = "user123"

    if (currentUser !in bannedUsers) {
        println("hi")
    }

}
