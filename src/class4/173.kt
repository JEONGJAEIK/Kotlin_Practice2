package class4

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")
}

fun main() {
    Button().click()
    Button().showOff()
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}