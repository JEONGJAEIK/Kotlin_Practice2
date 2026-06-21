package soksung.dsl18

data class Person(var name: String = "", var age: Int = 0)

// Person.() -> Unit은 Person 객체를 수신 객체로 받는, 반환 값이 없는 람다를 의미
fun person(init: Person.() -> Unit): Person {

    // 새로운 Person 객체 수신 객체가 될 대상 생성
    val p = Person()

    // 그 객체를 대상으로 전달받은 람다(init) 시행
    p.init()

    // 설정이 완료된 객체 반환
    return p
}

// 후행 람다 활용 빌더 호출
fun main() {
    val alice = person {
        // 여기는 Person.() -> Unit 람다의 내부
        // 'this'는 2단계에서 생성된 'p' 객체를 가리킴
        // 따라서 p.name = 또는 this.name 대신 프로퍼티 이름 바로 사용 가능
        name = "Alice"
        age = 30
    }
    println(alice)
}