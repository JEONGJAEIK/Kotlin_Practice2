package class4

data class Customer2(val name: String, val postalCode: Int)

fun main() {
    val c1 = Customer2("Sam", 11521)
    val c2 = Customer2("Mart", 15500)
    val c3 = Customer2("Sam", 11521)

    println(c1)
    println(c1 == c2)
    println(c1 == c3)
    println(c1.hashCode())
    println(c3.hashCode())
    println(c1.copy(postalCode = 11000))
}