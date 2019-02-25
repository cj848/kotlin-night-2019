
ext {
}

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    // Apply the application plugin to add support for building a CLI application.
    java
    id("org.springframework.boot") version "2.1.3.RELEASE"
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("io.mockk", "mockk", "1.9.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.bootJar {
    archiveFileName.set("app.jar")
    mainClassName = "night.kotlin._2019"
}