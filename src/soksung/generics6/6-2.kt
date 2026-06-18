package soksung

import kotlin.collections.List

open class Animal(open val age: Int)
class Dog(val name: String, override val age: Int) : Animal(age)
class Cat(val name: String, override val age: Int) : Animal(age)


fun main() {
    val dogs : MutableList<Dog> = mutableListOf(Dog("해피", 2))

    // val animals : MutableList<Animal> = dogs
    // 위 코드는 컴파일 오류지만 만약 가능하다면 animals 리스트는 Animal을 담을 수 있어 Cat을 추가하는 것도 가능해진다
    // animals.add(Cat("나비"))
    // 하지만 animals와 dogs는 같은 리스트 객체를 가리키고 있고 Dog만 들어있어야할 dogs리스트에서 Cat을 꺼내게 된다
    // val myDog: Dog = dogs[1] 여기서 ClassCastException 발생

    val dogs2: List<Dog> = listOf(Dog("해피", 2))
    val animal2: List<Animal> = dogs // List는 공변이라 안전하게 할당가능하다.

    // 동물의 나이를 비교하는 비교기
    val animalComparator: Comparator<Animal> = compareBy { it.age }

    // Dog를 비교해야 하는 곳에 Animal 비교기를 안전하게 사용할 수 있다.
//    val dogComparator: Comparator<Dog> = animalComparator
    // 컴패레터가 코틀린 라이브러리에 in이 안보임 수정이되었는가 책이 잘못되었는가
}

