package soksung

fun main() {
    for (i in 1..5) {
        println("$i")
    }

    val fruits = listOf("사과", "바나나", "딸기")
    for (fruit in fruits) {
        println("${fruit}는 맛있어!")
    }

    for ((index, fruit) in fruits.withIndex()) {
        println("${index + 1}번째 과일은 ${fruit}이다.")
    }

    var input: String

//    do {
//        println("종료하려면 'exit'를 입력")
//        input = readln()
//        println("입력 값: $input")
//    } while (input != "exit")
//    println("프로그램을 종료한다.")

    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        if (i == 7) {
            break
        }
        print("$i ")
    }
}