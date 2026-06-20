//package soksung.coroutineshard13
//
//import kotlinx.coroutines.CoroutineExceptionHandler
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.async
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//import java.io.IOException
//
//fun main() = runBlocking {
//    val job = launch { // 부모 코루틴 job
//        launch { // 자식 1
//            println("자식 1: 시작")
//            delay(1000L)
//            println("자식 1: 종료") // 이 코드는 실행되지 않음.
//        }
//        launch { // 자식 2
//            println("자식 2: 시작")
//            delay(500L)
//            throw IllegalStateException("자식 2에서 에러 발생")
//        }
//    }
//    job.join()
//    println("모든 작업 완료")
//
//    val job2 = launch {
//        try {
//            println("위험한 작업")
//            throw IOException("네트워크 연결 실패")
//        } catch (e: IOException) {
//            println("예외 발생: ${e.message}. 복구 로직을 수행한다.")
//        }
//    }
//
//    // async의 경우 예외는 즉시 발생하지 않고 Deferred 객체 내부에 저장됨
//    // await()를 호출하는 시점에 저장되어있던 예외가 던져짐
//    // 트라이 캐치는 await()를 감싸야함
//    val deferred = async {
//        // ...
//        throw IndexOutOfBoundsException("데이터없음")
//    }
//
//    try {
//        val result = deferred.await()
//        println("결과: $result")
//    } catch (e: IndexOutOfBoundsException) {
//        println("async 작업 실패: ${e.message}")
//    }
//
//    val handler = CoroutineExceptionHandler { coroutineContext, exception ->
//        // 이 람다는 처리되지 않은 예외가 발생했을 때 호출
//        println("처리되지 않은 예외 발생! context: $coroutineContext, exception: $exception")
//    }
//
//    // 스코프 생성 시 컨텍스트에 핸들러 추가
//    val scope = CoroutineScope(Dispatchers.Default + handler)
//
//    // 예외를 발생시키는 코루틴 실행
//    scope.launch {
//        throw ArithmeticException("0으로 나눌 수 없다.")
//    }
//}