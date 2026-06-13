package class4

sealed class Expr2
class Num2(val value: Int) : Expr2()
class Sum2(val left: Expr2, val right: Expr2) : Expr2()
class Mul2(val left: Expr2, val right: Expr2) : Expr2()

//fun eval(e: Expr2): Int =
//    when (e) {
//        is Num2 -> e.value
//        is Sum2 -> eval(e.right) + eval(e.left)
//    }
