package soksung.coroutineseasy12

import kotlinx.coroutines.delay

suspend fun fetchDataFormServer(): String {
    println("데이터 다운로드 시작")
    // delay는 코루틴 라이브러리에서 제공하는 suspend 함수
    // 지정된 밀리초만큼 코루틴을 차단하지 않고 기다림
    delay(1000L)
    println("데이터 다운로드 완료")
    return "서버 데이터"
}