rootProject.name = "otuskotlin-carsale"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings

        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

