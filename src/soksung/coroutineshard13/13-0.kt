package soksung.coroutineshard13

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyComponent {
    // 이 컴포넌트의 생명주기에 묶인 코루틴 스코프를 생성한다
    // Job()을 통해 이 스코프 내의 모든 코루틴을 한 번에 제어할 수 있다.
    private val scope = CoroutineScope(Dispatchers.Default + Job())

    fun performTask() {
        // 컴포넌트의 스코프에서 코루틴을 시작
        scope.launch {
            println("MyComponent 작업 시작")
            delay(2000L)
            println("MyComponent 작업 완료") // 이 메시지 출력 안됨
        }
    }

    // 컴포넌트 파괴 때 호출 메서드
    fun destroy() {
        println("컴포넌트 파괴 모든 작업 취소")
        // 스코프를 취소하면, 이 스코프에서 시작된 모든 자식 코루틴이 함께 취소
        scope.cancel()
    }
}

fun main() = runBlocking {
    val component = MyComponent()
    component.performTask()
    delay(1000L) // 작업이 1초간 실행되도록 잠시 대기
    component.destroy() // 1초 후 컴포넌트 파괴 (스코프 취소)
    delay(2000L) // 프로그램이 바로 끝나지 않도록 잠시 대기
}