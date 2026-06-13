package basic

fun main() {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isStudent)
    person.isStudent = false
    println(person.isStudent)
}