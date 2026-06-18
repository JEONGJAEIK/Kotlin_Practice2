package soksung

// Person 클래스 정의
class Person {
    // 클래스의 멤버 (프로퍼티와 메서드)가 이 안에 위치
    // 프로퍼티는 객체가 가지는 데이터나 상태를 나타냄
    // 자바에서는 필드를 private로 선언하고 게터 세터를 수동으로 만들지만 코틀린에서는 프로퍼티를 선언하는 것 만으로 모든 것이 간결하게 처리됨
    var name: String = "익명"
    val birthYear: Int = 2000

    // 메서드는 클래스 내부에 정의된 함수
    fun introduce() {
        // 메서드 내부에는 클래스의 프로퍼티에 직접 접근 가능
        println("Hi, 난 ${name}임 ㅋ. ${birthYear}년에 태어남 ㅇㅅㅇ")
    }
}

fun main() {
    val john = Person()
    val alice = Person()

    println(john.name)
    john.name = "홍길동"
    println(john.name)
    println(john.introduce())
    println(alice)
}