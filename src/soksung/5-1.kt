package soksung

class Person2(val name: String, val birthYear: Int) {

    // 부 생성자는 클래스 본문 내에 constructor 키워드로 선언하고 여러개 가질 수 있음
    // 주 생성자 만으로 부족한 특별한 방식의 객체 생성을 지원하기 위해 사용
    // 부 생성자는 반드시 자신이 직접 또는 다른 부 생성자를 통해 궁극적으로 주 생성자를 호출해야 함 이를 위임이라고 부르며 this()로 표현 결국 주 생성자를 거쳐야만함
    constructor(name: String) : this(name, 2025) {
        println("부 생성자 호출")
    }

    fun introduce() {
        println("Hi, 난 ${name}임 ㅋ. ${birthYear}년에 태어남 ㅇㅅㅇ")
    }
}

// 생성자 정의, 프로퍼티 선언, 객체 생성시 할당받은 인자를 프로퍼티에 자동할당함

fun main() {
    val p1 = Person2("애옹스", 2000)
    println("${p1.name} | ${p1.birthYear}")

    println("---")

    val p2 = Person2("Bob") // 부 생성자 호출
    println("${p2.name} | ${p2.birthYear}")
}