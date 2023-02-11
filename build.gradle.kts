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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.github.davidmoten:subethasmtp:5.2.4")
    implementation("org.apache.commons:commons-email:1.5")
    runtimeOnly("com.h2database:h2")

    testImplementation("io.projectreactor:reactor-test:3.4.24")
    testImplementation(kotlin("test"))
    testImplementation("org.mockito", "mockito-core", "2.1.0")
    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("io.kotlintest:kotlintest-assertions:3.4.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
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