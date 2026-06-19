package soksung.delegation10

interface Downloader {
    fun download(url: String)
}

class FileDownloader(private val file: String) : Downloader {
    override fun download(url: String) {
        println("$url 에서 $file 로 다운로드")
    }
}

// 수동 위임 : Downloader 인터페이스의 모든 메서드를 직접 오버라이딩하여 downloader에게 전달해야한다.
//class LoggingDownloader(private val downloader: Downloader) : Downloader {
//    override fun download(url: String) {
//        println("[로그] 다운로드 시작: $url")
//        downloader.download(url) // 실제 작업은 downloader 객체에게 위임
//        println("[로그] 다운로드 완료")
//    }
//}

// 코틀린의 클래스 위임
class LoggingDownloader(private val downloader: Downloader) : Downloader by downloader {

    // Downloader 인터페이스의 모든 멤버는 downloader 객체에게 자동으로 위임된다
    // 우리는 수정하고 싶은 메서드만 오버라이딩 하면됨
    override fun download(url: String) {
        println("[로그] 다운로드 시작: $url")
        downloader.download(url) // 필요하다면 원본 대리인 객체의 메서드를 직접 호출할 수도 있다.
        println("[로그] 다운로드 완료")
    }
}

fun main() {
    val fileDownloader = FileDownloader("my_movie.mp4")
    val loggingDownloader = LoggingDownloader(fileDownloader)
    loggingDownloader.download("http://example.com/movie")
}