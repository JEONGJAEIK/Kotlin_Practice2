package soksung

// vararg는 함수 내부로 전달되며 배열로 취급됨
fun printNumbers(vararg numbers: Int) { // 이 타입은 사실상 Array<Int>
    println("전달받은 숫자 개수: ${numbers.size}")
    for (number in numbers) {
        print("$number")
    }
    println()
}

//fun invalidFunc(vararg a: Int, vararg b: Int) {
//
//}

fun printUserInfo(vararg skills: String, department: String) {
    println("부서: $department")
    println("보유기술 : ${skills.joinToString(",")}}")
}
fun main() {
    printNumbers(1,2,3)
    printNumbers(10, 20, 30, 40, 50)
    printNumbers()
    printUserInfo("Java", "Kotlin", department = "개발1팀")

    // 함수에 전달할 값들이 이미 배열에 담겨있다면 vararg 함수에 그대로 전달할 수 없다.
    val numbersArray = intArrayOf(1, 2, 3, 4, 5)
//    printNumbers(numbersArray) 컴파일 오류
    // 스프레드 연산자 *는 배열 앞에 붙여서 배열의 내용을 펼쳐 각각의 요소를 개별 인자로 전달해준다
    printNumbers(*numbersArray)
}