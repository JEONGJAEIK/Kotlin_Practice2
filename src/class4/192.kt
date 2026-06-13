package class4

open class User (val nickname: String,
    val isSubscribed: Boolean = true)

class SocialUser(nickname: String) : User(nickname)

fun main() {
    val alice = User("Alice")
    println(alice.isSubscribed)

    val bob = User("Bob", false)
    println(bob.isSubscribed)

    val carol = User("Carol", isSubscribed = false)
    println(carol.isSubscribed)

    val dave = User(nickname = "Dave", isSubscribed = true)
    println(dave.isSubscribed)
}

open class Button4

class RadioButton4: Button4()

class Secretive private constructor(private val agentName: String)