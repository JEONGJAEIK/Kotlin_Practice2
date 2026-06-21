package soksung.dsl18

data class Address(
    val street: String,
    val city: String
)

data class Person2(
    val name: String,
    val age: Int,
    val address: Address?
)

// Address 생성을 위한 빌더
class AddressBuilder {
    var street: String = ""
    var city: String = ""

    fun build(): Address = Address(street, city)
}

// Person2 생성을 위한 빌더
class PersonBuilder {
    var name: String = ""
    var age: Int = 0
    private var address: Address? = null // 완성된 Address 객체를 저장할 변수

    /**
     * 이것이 중첩 DSL의 핵심이다.
     * PersonBuilder의 컨텍스트 안에서 address {...} 람다를 호출할 수 있도록
     * address라는 이름의 메서드를 제공
     * 이 메서드는 AddressBuilder를 수신 객체로 받는 람다를 인자로 받음
     */
    fun address(init: AddressBuilder.() -> Unit) {
        // AddressBuilder를 만들고 람다로 초기화한 뒤 build() 하여
        // 완성된 Address 객체를 내부 프로퍼티에 저장한다.
        this.address = AddressBuilder().apply(init).build()
    }

    fun build(): Person2 = Person2(name, age, address)
}

fun person2(init: PersonBuilder.() -> Unit): Person2 {
    // PersonBuilder 인스턴스 생성
    val builder = PersonBuilder()

    // 생성된 빌더 객체를 수신 객체(this)로 하여 사용자 람다(init)를 실행
    builder.init()

    // 람다를 통해 모든 설정이 완료된 빌더로 최종 객체 생성하여 반환
    return builder.build()
}

fun main() {
    val alice = person2 {
        // 여기는 PersonBuilder의 컨텍스트
        // 따라서 PersonBuilder의 프로퍼티에 바로 접근 가능
        name = "Alice"
        age = 30

        // address는 PersonBuilder에 정의된 메서드
        address {
            // 이 블록은 AddressBuilder의 컨텍스트
            street = "123 Main St"
            city = "Wonderland"
//            age = 50 버그 30살이 50살로 덮어 씌워짐
        }
        // street = "" 컴파일 오류 접근 불가
    }
    println(alice)
}