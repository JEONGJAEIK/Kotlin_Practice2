//package soksung.coroutineshard13
//
//import kotlinx.coroutines.channels.Channel
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//fun main() = runBlocking {
//    // 4개의 값을 담을 수 있는 버퍼를 가진 채널 생성
//    val channel = Channel<Int>(4)
//
//    // 생산자 코루틴
//    launch {
//        for (x in 1..10) {
//            println("Sending $x")
//            channel.send(x) // 버퍼가 꽉 차면 여기서 일시 중단됨
//        }
//        channel.close() // 모든 데이터를 보내고 채널을 닫아야함
//}