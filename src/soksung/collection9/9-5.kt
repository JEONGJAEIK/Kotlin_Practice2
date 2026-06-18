package soksung.collection9

import java.io.File


fun main() {
    // 프로젝트 루트 경로에 있는 my_file.txt 파일을 가리키는 File 객체 생성
    val file = File("my_file.txt")

    // 파일이 없으면 FileNotFoundException
    val content: String = file.readText()
    println(content)

    // 파일 줄 단위로 읽기
    // 파일의 각 줄을 요소로 하는 List<String> 얻기
    val lines: List<String> = file.readLines()
    lines.forEachIndexed { index, line ->
        println("${index + 1}: $line")
    }

    // 대용량 파일일때 readText readLines는 파일의 모든 내용을 메모리에 올려서 OOM 발생가능
    // useLines는 파일을 한 줄씩 지연시키는 Sequence<String> 제공 람다 블록이 끝나면 파일 자동으로 닫아짐
    // 1GB 크기의 로그 파일에서 ERROR가 포함된 줄만 찾아서 출력
    File("huge_logfile.log").useLines { lines ->
        lines.filter { it.contains("ERROR") }
            .take(5) // 에러 5개만 찾으면
            .forEach { println(it) } // 출력 후 종료
    } // 람다가 끝나면 파일 스트림은 자동으로 닫힘

    // 텍스트 파일 쓰기
    val outputFile = File("output.txt")
    outputFile.writeText("냥")

    // 텍스트 이어 쓰기
    outputFile.appendText("\n 새로운 줄 추가")


    // 파일을 열거나 네트워크에 연결하는 등의 작업 후에는 자원을 닫아주어야함 코틀린은 Closeable 인터페이스를 구현하는 모든자원에 대해 use라는 확장함수 제공
    // use는 람다 블록을 인자로 받아 자원을 this로 넘겨주고, 람다 블록이 정상적으로 끝나거나 또는 예외가 발생하여 끝나더라도 항상 자원의 close() 메서드 호출을 보장
    // try-with-resources와 동일한 역할

    fun copyFile(sourcePath: String, destPath: String) {
        File(sourcePath).inputStream().use { input ->
            File(destPath).outputStream().use { output  ->
                input.copyTo(output)
            }
        } // input과 output 스트림은 여기서 자동으로 닫힘
    }
}