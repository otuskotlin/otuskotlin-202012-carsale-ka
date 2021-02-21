plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
    kotlin("js") apply false
    kotlin("plugin.serialization") apply false
}

group = "ru.otus.otuskotlin.carsale"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
        maven { url = uri("https://kotlin.bintray.com/kotlinx") } // soon will be just jcenter()
    }
}
