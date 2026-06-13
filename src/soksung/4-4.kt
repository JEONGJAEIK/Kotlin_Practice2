package soksung

// 파일 A
fun isAllUpperCase(str: String): Boolean {
    return str.all{ it.isUpperCase() }
}

fun saveUser(name: String, email: String, address: String) {

    fun validate(value: String, fieldName: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("$fieldName cannot be blank.")
        }
    }

    validate(name, "Name")
    validate(email, "Email")
    validate(address, "Address")

    println("Saving user: $name, $email, $address")
}