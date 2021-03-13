package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.InternalSerializationApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.otus.otuskotlin.carsale.backend.app.ktor.module
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.serializer.jsonConfig
import kotlin.test.assertEquals
import kotlin.test.fail

abstract class AbstractControllerTest {

    val log: Logger = LoggerFactory.getLogger(this::class.java)

    @OptIn(InternalSerializationApi::class)
    inline fun <reified T : Message, reified R : Message> handleRequest(
        method: HttpMethod, uri: String, request: T, crossinline block: suspend (R, TestApplicationCall) -> Unit): Unit {

        withTestApplication({ module(testing = true) }) {
            handleRequest(method, uri) {
                val bodyString = jsonConfig.encodeToString(Message.serializer(), request)
                setBody(bodyString)
                addHeader("Content-Type", "application/json")

            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content ?: fail("Empty response content")
                log.debug("Response(string): {}", jsonString)
                val res = jsonConfig.decodeFromString(Message.serializer(), jsonString) as? R
                    ?: fail("Incorrect response format")
                log.debug("Response: {}", res)

                runBlocking {
                    block(res, this@apply)
                }
            }
        }
    }
}