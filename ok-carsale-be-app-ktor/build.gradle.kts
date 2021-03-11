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

//docker {
////  url = 'https://192.168.59.103:2376'
////  certPath = new File(System.properties['user.home'], '.boot2docker/certs/boot2docker-vm')
//
////    registryCredentials {
////        url.set(dockerParams.dockerUrl)
////        dockerParams.dockerUser?.also { username.set(it) }
////        dockerParams.dockerPass?.also { password.set(it) }
////    email = 'benjamin.muschko@gmail.com'
////    }
//
//    javaApplication {
//        baseImage.set("adoptopenjdk/openjdk11:alpine-jre")
//        maintainer.set("(c) Otus")
//        ports.set(listOf(8080))
//        val imageName = project.name
//        images.set(listOf(
//            "$imageName:${project.version}",
//            "$imageName:latest"
//        ))
//        jvmArgs.set(listOf("-Xms256m", "-Xmx512m"))
//    }
//}

