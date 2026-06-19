plugins {
    kotlin("jvm") version "2.3.21"
}

group = "soksung"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // delay 등 suspend 유틸이 들어있는 코루틴 코어 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

// 기존 IntelliJ 프로젝트의 플랫한 소스 구조(src/ 바로 아래 패키지)를 그대로 사용
sourceSets {
    main {
        kotlin.srcDirs("src")
        resources.srcDirs("resources")
    }
    test {
        kotlin.srcDirs("test")
        resources.srcDirs("testResources")
    }
}

kotlin {
    jvmToolchain(21)
}
