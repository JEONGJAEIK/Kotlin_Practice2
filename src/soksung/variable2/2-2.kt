package soksung

val simpleNumber = 100 // Int 추론
val bigNumber = 1000000000L // Long 타입 지정

val pi = 3.141592 // Double 추론
val piFloat = 3.141592f // Float 지정

val isUserLoggedIn: Boolean = true
val isReady: Boolean = false

val firstLetter: Char = 'A'
val symbol: Char = '%'
val koreanChar: Char = '가'

val greeting: String = "Hello, World!"

val name = "Kotlin"
val message = "My name is $name"

val a = 10
val b = 20

val htmlSource = """
    <html>
        <head>
            <title>Hello!</title>
        </head>
        <body>
            <h1>This is a multiline string.</h1>
        </body>
    </html>
""".trimIndent()

fun main() {
    println("a + b = ${a + b}")
}