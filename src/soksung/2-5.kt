package soksung

interface Shape
class Circle(val radius: Double) : Shape
class Rectangle(val width: Double, val height: Double) : Shape

fun printArea(shape: Shape) {
    if (shape is Circle) {
        // 이 블록 안에서 컴파일러는 shape가 Circle 타입임을 알고있다.
        println("원의 반지름: ${shape.radius}")
    } else if (shape is Rectangle) {
        println("사각형의 너비: ${shape.width}")
    }
}

fun getShapeDescription(shape: Shape) : String {
    return when (shape) {
        // 분기마다 해당 타입으로 스마트 캐스팅 발생
        is Circle -> "반지름이 ${shape.radius}인 원"
        is Rectangle -> "너비 ${shape.width}, 높이 ${shape.height}의 사각형"
        else -> "알 수 없는 도형"
    }
}

fun printTextLength(text: String?) {
    if (text != null) {
        // text가 null이 아님이 확인되면 text는 String?이 아닌 String으로 취급됨
        // 따라서 ?. 불필요
        println(text.length)
    } else {
        println("No tex")
    }
}