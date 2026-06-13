package class4

interface User2 {
    val nickname: String // 인터페이스의 추상 프로퍼티
    // 인터페이스의 프로퍼티 선언에는 백킹필드 게터등이 없다
    // 상태를 저장할 필요가 있다면 하위 클래스에서 프로퍼티를 만들어야 함
}

class PrivateUser(override val nickname: String) : User2

class SubscribingUser(val email: String) : User2 {
    override val nickname: String
        get() = email.substringBefore('@')
}

class SocialUser2(val accountId: Int) : User2 {
    override val nickname = getNameFromSocialNetwork(accountId)
}

fun getNameFromSocialNetwork(accountId: Int) = "kodee$accountId"

fun main() {
    println(PrivateUser("kodee").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
    println(SocialUser2(123).nickname)
}

interface EmailUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}