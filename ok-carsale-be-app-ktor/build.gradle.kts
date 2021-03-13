plugins {
    application
    kotlin("jvm")
    id("com.bmuschko.docker-java-application")
}

group = rootProject.group
version = rootProject.version

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenLocal()
}

dependencies {
    val ktorVersion: String by project
    val logbackVersion: String by project
    val datetimeVersion: String by project

    implementation(project(":ok-carsale-be-common"))
    implementation(project(":ok-carsale-mp-transport"))
    implementation(project(":ok-carsale-mp-common"))

    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$datetimeVersion")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}
docker {
    javaApplication {
        baseImage.set("openjdk:11-jdk-slim")
        maintainer.set("Alexandr Kovalev")
        ports.set(listOf(8080))
        val imageName = project.name
        images.set(
            listOf(
                "$imageName:${project.version}",
                "$imageName:latest"
            )
        )
        jvmArgs.set(listOf("-Xms512m", "-Xmx512m"))
    }
}