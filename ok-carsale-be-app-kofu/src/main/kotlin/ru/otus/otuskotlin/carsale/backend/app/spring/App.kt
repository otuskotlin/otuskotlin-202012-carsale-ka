package ru.otus.otuskotlin.carsale.backend.app.spring

import org.springframework.boot.logging.LogLevel
import org.springframework.fu.kofu.webApplication
import org.springframework.fu.kofu.webmvc.webMvc
import ru.otus.otuskotlin.carsale.backend.app.spring.config.brandConfig
import ru.otus.otuskotlin.carsale.backend.app.spring.config.modelConfig

private val webApp = webApplication {
    logging {
        level = LogLevel.DEBUG
    }

    webMvc {
        port = if (profiles.contains("test")) 8181 else 8080

        converters {
            string()
            kotlinSerialization()
        }
    }

    enable(brandConfig)
    enable(modelConfig)
}

fun main() {
    webApp.run()
}