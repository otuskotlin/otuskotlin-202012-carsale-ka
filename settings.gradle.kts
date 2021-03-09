rootProject.name = "otuskotlin-carsale"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val springDependencyVersion: String by settings
        val springBootVersion: String by settings

        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
        id("org.springframework.boot") version springBootVersion apply false
        id("io.spring.dependency-management") version springDependencyVersion apply false
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

include("ok-carsale-be-common")

include("ok-carsale-mp-common")
include("ok-carsale-mp-transport")

include("ok-carsale-be-app-kofu")