package soksung

fun createUser(name: String, age: Int,
               country: String = "Korea",
               language: String = "Korean",
               isActive: Boolean = true) {
    println("이름: $name, 나이: $age, 국가: $country, 언어: $language, 활성: $isActive")
}

fun main() {
    createUser("Alice", 30)
    createUser("Bob", 25, "USA")
    createUser(
        name = "Charlie",
        age = 40,
        isActive = false
    )

    createUser(
        age = 22,
        isActive = false,
        name = "David"
    )

    createUser("Eve", 28, language = "English")
//    createUser(name = "Frank", "German")
}