package soksung

import class4.Customer


fun main() {
    val name: String? = null
    var displayName: String

    if (name != null) {
        displayName = name
    } else {
        displayName = "Guest"
    }

    // ?: 왼쪽이 null이 아니면 그 값을 그대로 사용 만약 null이면 오른쪽의 표현식을 값으로 사용
    val name2: String? = null
    var displayName2: String = name2 ?: "Guest" // name2가 null이라서 Guest 사용
    println("Hello $displayName2")

    val realName: String? = "Alice"
    val displayName3: String = realName ?: "Guest" // null이 아니라 Alice 사용
    println("Hello $displayName3")

    val studentWithNoProfessor = Student(Department(null))
    val professorName = studentWithNoProfessor.department?.headProfessor?.name ?: "담당 교수 미정"
    println("담당 교수: $professorName")
}

fun printShippingLabel(customer: Customer) {
    // customer가 null이며 함수를 즉시 종료
    val address = customer?.name ?: return

    // 여기부터 컴파일러는 address가 null이 아님을 알고 있다.
    println(address.length)
}

fun processPayment(amount: Double?) {
    val validAmount = amount ?: throw IllegalArgumentException("결제 금액은 null일 수 없다")
    println("결제를 진행한다: $validAmount 원")
}