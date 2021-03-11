rootProject.name = "otuskotlin-carsale"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val springDependencyVersion: String by settings
        val springBootVersion: String by settings
        val bmuschkoVersion: String by settings

        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false

        id("org.springframework.boot") version springBootVersion apply false
        id("io.spring.dependency-management") version springDependencyVersion apply false
        id("com.bmuschko.docker-java-application") version bmuschkoVersion
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

// Backend subprojects
include("ok-carsale-be-common")

// Multiplatform subprojects
include("ok-carsale-mp-common")
include("ok-carsale-mp-transport")

// Web subprojects
include("ok-carsale-be-app-kofu")
include("ok-carsale-be-app-ktor")