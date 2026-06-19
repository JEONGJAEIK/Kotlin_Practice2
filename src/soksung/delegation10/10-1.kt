package soksung.delegation10

import kotlin.properties.Delegates

class UserProfile(userId: String) {
    // profilePhoto 프로퍼티는 실제로 접근되기 전까지 로딩되지 않음
    val profilePhoto: Unit by lazy {
        println("[${userId}]의 프로필 사진을 로딩 이 메시지는 한번만 보임")
        // 대충 무거운 작업
    }
}

class User {
    // name 프로퍼티의 변경을 감시
    var name: String by Delegates.observable("<이름 없음>") { prop, oldValue, newValue ->
        println("${prop.name} 프로퍼티가 '${oldValue}'에서 '${newValue}'(으)로 변경되었다.")
    }
}

class PositiveNumber {
    // 0 이상의 값만 허용하는 프로퍼티
    var value: Int by Delegates.vetoable(0) { prop, oldValue, newValue ->
        newValue >= 0 // 이 조건이 true일 때만 값이 변경됨
    }
}

fun main() {
    val user = UserProfile("user123")
    println("UserProfile 객체 생성 완료")

    println("첫 번째 사진 접근:")
    user.profilePhoto // 이 순간 lazy 블록 실행

    println("\n두 번째 사진 접근:")
    user.profilePhoto // 이미 캐시된 값이므로 lazy 블록 실행 안 됨

    val user2 = User()
    user2.name = "Alice"
    user2.name = "Bob"

    val number = PositiveNumber()
    println(number.value)

    number.value = 10
    println(number.value) // 변경 승인

    number.value = -5
    println(number.value) // 변경 거부, 이전 값 유지
}