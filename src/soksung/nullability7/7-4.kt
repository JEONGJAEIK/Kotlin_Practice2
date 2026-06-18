package soksung



//class MyActivity {
//    // 아직 초기화할 수 없지만, null이 될 수 없는 TextView 프로퍼티
//    private lateinit var textView: TextView
//    private lateinit var apiService: ApiService
//
//}

class User(val nickname: String)

class UserSession(private val userId: String) {
    // userProfile 프로퍼티는 처음 접근될 때 데이터베이스 조회를 통해 초기화 됨
    val userProfile: User by lazy {
        println("DB에서 프로필 로딩 중")
        User("ㅇㅅㅇ")
        // 작업 ...
    }
}

fun main() {
    val session = UserSession("123")
    println("세션 객체 생성")

    // 이 순간 lazy 블록 실행
    println(session.userProfile.nickname)

    // 이미 초기화 되어 lazy 블록 실행안됨
    println(session.userProfile.nickname)

}