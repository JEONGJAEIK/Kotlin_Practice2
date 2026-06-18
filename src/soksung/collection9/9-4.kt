package soksung.collection9


// groupBy 컬렉션의 각 요소를 특정 기준에 따라 여러 그룹으로 묶어 Map을 생성함
// 람다는 각 요소를 어떤 키에 할당할지를 결정하며, 생성된 Map의 값은 해당 키를 가진 요소들의 List가 됨

data class Person(val name: String, val city: String)

fun main() {
    val people = listOf(
        Person("Alice", "서울"),
        Person("Bob", "부산"),
        Person("Charlie", "서울"),
        Person("David", "부산"),
        Person("Eve", "제주")
    )

    // 거주 도시를 기준으로 사람을 그룹화
    val peopleByCity: Map<String, List<Person>> = people.groupBy { it.city }

    peopleByCity.forEach { (city, residents) ->
        println("[$city]")
        residents.forEach { person ->
            println(" - ${person.name}")
        }
    }

    // 분할 partition은 그룹바이의 특별한 경우 컬렉션을 단 두개의 그룹으로 나누는데 사용
    // 람다는 각 요소를 검사하여 true 또는 false를 반환해야함
    // partition은 그 결과에 따라 두 개의 리스트가 담긴 Pair 객체 반환
    // 첫 번째 리스트는 조건을 만족하는 true 요소 두번째 리스트는 만족하지 못하는 false요소 담음
    // partition은 동전을 두 종류로 나누는 것과 같음 이 동전은 100원 짜리인가? 라는 기준(람다)에 따라 '100원짜리 더미'와 '나머지 더미' 두 개로 분리됨

    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val (evens, odds) = numbers.partition { it % 2 == 0 }
    println("짝수: $evens")
    println("홀수: $odds")
}