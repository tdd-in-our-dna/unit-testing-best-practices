import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("plugin.spring") version "1.5.10"
}

group = "com.tw.tddinourdna"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.projectreactor:reactor-core:3.4.24")
    testImplementation("io.projectreactor:reactor-test:3.4.24")
    testImplementation(kotlin("test"))
    testImplementation("org.mockito", "mockito-core", "2.1.0")
    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("io.kotlintest:kotlintest-assertions:3.4.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}