package soksung

fun main() {
    val dayOfWeek = 3

    when (dayOfWeek) {
        1 -> println("월요일")
        2 -> println("화요일")
        3 -> println("수요일")
        4 -> println("목요일")
        5 -> println("금요일")
        else -> println("주말 또는 잘못된 값")
    }

    when (dayOfWeek) {
        1, 2, 3, 4, 5 -> println("주중 (Weekday)")
        6, 7 -> println("주말 (Weekend)")
    }

    val score = 85
    when (score) {
        in 90..100 -> println("A 등급")
        in 80..89 -> println("B 등급")
        in 70..79 -> println("C 등급")
        else -> println("F 등급")
    }

    val name = "Kotlin"
    val score2 = 95

    when {
        name == "Kotlin" && score2 > 90 -> {
            println("Good")
        }
        name.startsWith("J") -> {
            println("JAVA?")
        }
        else -> {
            println("BABO")
        }
    }

    val grade = when(score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
    println("학점: ${grade}")
}

fun checkType(obj: Any) {
    when (obj) {
        is String -> {
            // obj가 스트링이 확인되고 스마트 캐스팅
            println("문자열 길이: ${obj.length}")
        }
        is Int -> {
            println("정수 값의 두 배: ${obj * 2}")
        }
        else -> {
            println("알 수 없는 타입")
        }
    }
}