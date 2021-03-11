package ru.otus.otuskotlin.carsale.backend.app.kofu.controller

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.InternalSerializationApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

abstract class AbstractController {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    @OptIn(InternalSerializationApi::class)
    inline fun <reified T : Any, reified R : Any> ServerRequest.handle(crossinline block: suspend (T) -> R): ServerResponse {
        log.debug("Trying handling serverRequest: {}", this)
        val request = this.body(T::class.java)
        log.debug("Request: {}", request)
        val response = runBlocking { block(request) }
        log.debug("Response: {}", response)
        return ServerResponse.ok().body(response)
    }
}