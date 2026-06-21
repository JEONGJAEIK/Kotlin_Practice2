package soksung.coroutineshard13

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// 1초마다 1부터 3까지의 숫자를 방출하는 Flow를 생성하는 함수
fun simpleFlow(): Flow<Int> = flow {
    println("Flow가 시작되었다")
    for (i in 1..3) {
        delay(1000L)
        emit(i)
    }
}

//fun main() = runBlocking {
//    println("메인: collect 호출")
//    val flow = simpleFlow()
//
//    // collect 호출 순간, flow {...} 블록의 코드가 실행되기 기작
//    flow.collect { value ->
//        println("메인: 수집된 값 -> $value")
//    }
//
//    println("메인: collect 완료")
//}

fun main() = runBlocking {
    (1..5).asFlow() // 1부터 5까지의 숫자를 방출하는 Flow 생성
        .filter { // 중간 연산자 1: 필터링
            println("Filter: $it")
            it % 2 != 0 // 홀수만 통과
        }
        .map { // 중간 연산자 2: 변환
            println("Map: $it")
            "숫자 [${it}]" // 숫자를 문자열로 변환
        }
        .collect { result -> // 종단 연산자: 최종 결가를 소비
            println("Collect: $result")
        }

}