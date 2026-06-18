package soksung

//fun <T> checkType(items: List<Any>) {
////    if (items is List<T>) {
////        컴파일 오류 런타임에는 T가 어떤 타입인지 확인 할 수 없다.
////    }
//}

//fun <T> printClassName() {
//    // println(T::class.java.simpleName)
//    // T는 런타임에 실체가 없는 타입이므로 클래스 정보를 가져올 수 없다.
//}

// 함수를 inline으로 만들고 타입 파라미터 T에 reified를 붙인다
inline fun <reified T> isInstanceOf(value: Any) : Boolean {
    // 이제 런타임에 T의 타입을 알 수 있으므로, is T 검사가 가능함
    return value is T
}

// List에 대한 확장 함수로 정의
inline fun <reified T> List<Any>.findFirstInstanceOf(): T? {
    for (item in this) {
        if (item is T) {
            return item // item이 T타입이면 스마트 캐스팅 되어 안전하게 반환
        }
    }
    return null
}

fun main() {
    val mixedList: List<Any> = listOf("Kotlin", 1, "Java", 2.0, Person2("Alice", 30))

    // String 타입의 첫번째 요소 찾기
    val firstString = mixedList.findFirstInstanceOf<String>()
    println(firstString)

    // Person2 타입의 첫번째 요소 찾기
    val firstPerson = mixedList.findFirstInstanceOf<Person2>()
    println(firstPerson)
    println(isInstanceOf<String>("hello"))
    println(isInstanceOf<Int>("hello"))
}