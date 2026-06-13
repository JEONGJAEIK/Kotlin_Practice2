package soksung

fun main() {
    val value: Any = "Hello"
    val str: String = value as String
    val anotherValue: Any = 123
//    val str2: String = anotherValue as String // 런타임 오류 ClassCastException 발생
    // 정수는 문자열로 변환될 수 없다

    // as? 는 왼쪽의 객체를 오른쪽의 타입으로 변환하고 성공하면 변환된 값을 주고 실패하면 null을 반환

    val str2: String? = anotherValue as? String
    println("변환 결과: $str2")

    // as? 연산의 결과 값은 항상 Nullable 타입이 된다.

    val value1: Any = "I am a string"
    val value2: Any = 123

    // value1을 Int로 변환 시도, 성공하면 0을 기본값으로 사용
    val intValue1 = value1 as? Int ?: 0
    val intValue2 = value2 as? Int ?: 0
    println(intValue1)
    println(intValue2)
}