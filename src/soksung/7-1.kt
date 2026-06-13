package soksung

// 학생은 소속된 학과가 없을 수도 있고, 학과에는 지도교슈가 없을 수도 있다.
class Professor(val name: String)
class Department(val headProfessor: Professor?)
class Student(val department: Department?)

fun getProfessorName(student: Student): String? {
    // student -> department -> headProfessor -> name 순으로 안전하게 접근
    return student.department?.headProfessor?.name
}

fun main() {
    val prof = Professor("김교수")
    val compSci = Department(prof)
    val studentA = Student(compSci)
    println(getProfessorName(studentA))

    val studentB = Student(Department(null))
    println(getProfessorName(studentB))

    val studentC = Student(null)
    println(getProfessorName(studentC))

    val name2: String? = "dd"

    name2?.let {
        // 이 블록이 null이 아닐 때만 실행된다
        // 블록 안에서 it은 null이 아닌 String 타입으로 스마트 캐스팅된다
        println("이름: $it")
        println("길이: ${it.length}")
        println("대문자 ${it.uppercase()}")
    }



    var name: String? = "Kotlin"
    val length: Int? = name?.length
    println("이름의 길이: $length")

    name = null

    // name이 null이라 length는 호출되지 않고 표현식 전체가 null이 됨
    val length2: Int? = name?.length
    println("이름의 길이: $length2")

}