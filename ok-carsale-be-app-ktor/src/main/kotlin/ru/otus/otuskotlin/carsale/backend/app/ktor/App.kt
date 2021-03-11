package ru.otus.otuskotlin.carsale.backend.app.ktor

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import ru.otus.otuskotlin.carsale.backend.app.ktor.config.brandRoute
import ru.otus.otuskotlin.carsale.backend.app.ktor.config.contactRoute
import ru.otus.otuskotlin.carsale.backend.app.ktor.config.modelRoute
import ru.otus.otuskotlin.carsale.backend.app.ktor.config.saleAdRoute
import ru.otus.otuskotlin.carsale.transport.serializer.jsonConfig

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {

    // This adds automatically Date and Server headers to each response, and would allow you to configure
    // additional headers served to each response.
    install(DefaultHeaders)

    // This uses use the logger to log every call (request/response)
    install(CallLogging)

    install(ContentNegotiation) {
        json(
            contentType = ContentType.Application.Json,
            json = jsonConfig,
        )
    }

    routing {
        get("/") {
            call.respondText("202012, Продажа Авто, Ковалев Александр", contentType = ContentType.Text.Plain)
        }

        static("/static") {
            resources("static")
        }

        brandRoute()
        modelRoute()
        contactRoute()
        saleAdRoute()
    }
}