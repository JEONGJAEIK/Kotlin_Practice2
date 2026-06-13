package class4

class MyClass {
    companion object {
        fun callMe() {
            println("Companion object called")
        }
    }
}

fun main() {
    val myObject = MyClass()
    MyClass.callMe()
}