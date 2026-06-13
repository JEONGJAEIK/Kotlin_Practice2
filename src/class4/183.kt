package class4

internal open class TalkativeButton {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

// giveSpeech 확장 함수의 가시성을 internal이나 TalkativeButton 클래스의 가시성을 public으로 바꾸면 컴파일 오류 사라짐
//fun TalkativeButton.giveSpeech() { // 오류 : 퍼블릭 멤버가 자신의 internal 수신 타입인 TalkativeButton을 노출
//    yell() // 오류 : yell에 접근 x yell은 TalkativeButton의 private 멤버
//    whisper() // 오류 : whisper에 접근 x whisper는 TalkativeButton의 protected 멤버
//}