package soksung.coroutineshard13

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()

    // 생산자 코루틴
    launch {
        for (x in 1..5) {
        println("${x * x} 값을 채널에 보낸다...")
        channel.send(x * x) // 제곱한 값을 채널에 보냄
        delay(200L)
        }
        channel.close() // 모든 데이터를 보내고 채널을 닫아야함
    }

    // 소비자 코루틴
    // 채널이 close() 되면 루프는 자동으로 종료
    for (receivedValue in channel) {
        println("...채널에서 ${receivedValue} 값을 받았다.")
    }
    println("모든 데이터 수신 완료!")


}