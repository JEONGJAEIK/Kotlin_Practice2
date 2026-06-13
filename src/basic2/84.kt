package basic

fun canPerformOperation(): Boolean {
    return true
}

fun main() {
    val result: String
    result = if (canPerformOperation()) {
        "Success"
    } else {
        "dd"
    }
}