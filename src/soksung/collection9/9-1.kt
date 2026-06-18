package soksung.collection9

fun main() {
    val numbers = listOf(10, 20, 30)
    val colors = setOf("Red", "Green", "Blue")
    val userMap = mapOf("name" to "Alice", "age" to 30)
    val mutableNumbers = mutableListOf(1, 2, 3)
    val emptyList: List<String> = emptyList()
    val emptyMutableList = mutableListOf<String>()

    // 10 미만의 짝수만 담는 읽기 전용 리스트 생성
    // 중간에서만 add같은 변경 작업을 허용하고 최종 결과물을 불변성을 보장받음
    val evenNumbers: List<Int> = buildList {
        for (i in 0 until 10) {
            if (i % 2 == 0) {
                add(i) // buildList 블록 안에서 this가 MutableList처럼 동작
            }
        }
    }
    println(evenNumbers)

    // 다른 컬렉션 복사
    val originalList = listOf(1, 2, 3, 2)

    // List를 Set으로 변환 - 중복 제거
    val numberSet = originalList.toSet()
    println(numberSet)

    // Set을 변경가능한 List로 변환
    val mutableListFromSet = numberSet.toMutableList()
    mutableListFromSet.add(4)
    println(mutableListFromSet)
}