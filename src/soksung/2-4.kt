package soksung

fun main() {
    var name: String = "Kotlin"
    // name = null 기본적으로 널을 가질 수 없음
    var nullableName: String? = "Kotlin"
    var otherName: String? = "dd"
    nullableName = null
    // println(nullableName.length) 컴파일 오류
    println(nullableName?.length) // null이 아니면 호출하고 null이면 null 반환
    println(otherName?.length)
//    println(nullableName!!.length) // !!는 절대 null이 아니다
    var name2: String? = getFixedName()
    val length: Int = name2!!.length
    println(length)
}

fun getFixedName(): String? = "Kotlin"