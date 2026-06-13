package class4

class User3(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".
                """.trimIndent())
            field = value
        }
}

fun main() {
    val user = User3("Alice")
    user.address = "Christoph-Rapparini-Bogen 23"
}

class Person(var birthYear: Int) {
    var ageIn2050
        get() = 2050 - birthYear
        set(value) {
            birthYear = 2050 - value
        }
}