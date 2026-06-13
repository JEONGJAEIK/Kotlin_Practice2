package class4

class Customer(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
    override fun toString() = "Customer(name=$name, postalCode=$postalCode)"
}

fun main() {
    val processed = hashSetOf(Customer("오현석",4122))
    println(processed.contains(Customer("오현석", 4122)))
}

