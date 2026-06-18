package soksung

fun printAnyList(list: MutableList<Any>) {
    list.forEach { println(it)}
}

fun printAnyList2(list: MutableList<*>) {
    // 읽기 가능 각 item은 Any?로 취급 됨
    for (item in list) {
        println(item)
    }

    // 쓰기 불가능
    // list.add(10) 컴파일 오류

    // size 처럼 타입 T와 무관한 메서드는 호출 가능
    println("리스트 크기: ${list.size}")
}

fun main() {
    val strings : MutableList<String> = mutableListOf("A", "B", "C")
    // printAnyList(strings) 컴파일 오류 MutableList<String>은 MutableList<Any>의 하위 타입이 아님
    // printAnyList는 리스트의 내용을 읽기만 하지만 무공변 때문에 MutableList<String>을 인자로 받을 수 없다.
    // 타입 프로젝션으로 해결 가능

    val ints: MutableList<Int> = mutableListOf(1, 2, 3)

    printAnyList2(strings)
    printAnyList2(ints)
}
