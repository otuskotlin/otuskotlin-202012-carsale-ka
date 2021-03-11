package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.InternalSerializationApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.otus.otuskotlin.carsale.transport.model.common.*

abstract class AbstractController {

    val log: Logger = LoggerFactory.getLogger(this::class.java)

    @OptIn(InternalSerializationApi::class)
    suspend inline fun <reified T : Request, reified R : Message> PipelineContext<Unit, ApplicationCall>.handle(
        crossinline block: suspend (T) -> R): Unit {

        val classDiscriminator = R::class.java.name
        var request: T? = null

        try {
            log.debug("Trying handling receive")
            request = call.receive<Message>() as T
            log.debug("Request: {}", request)

        } catch (e: Exception) {
            returnError(e, ResponseStatusDto.BAD_REQUEST, request?.requestId, classDiscriminator)
        }

        if (request == null) {
            return
        }

        try {
            val response: Message = block(request)
            log.debug("Response: {}", response)
            call.respond(response)

        } catch (e: Exception) {
            returnError(e, ResponseStatusDto.INTERNAL_SERVER_ERROR, request?.requestId, classDiscriminator)
        }
    }

    suspend inline fun PipelineContext<Unit, ApplicationCall>.returnError(
        e: Exception, status: ResponseStatusDto, requestId: String?, classDiscriminator: String) {

        log.error("Error:", e)
        val response = ErrorResponse(
            type = classDiscriminator,
            onRequest = requestId,
            status = when(e) {
                is IllegalArgumentException,
                is java.lang.IllegalArgumentException -> ResponseStatusDto.BAD_REQUEST
                else -> status
            },
            errors = listOf(
                ErrorDto(
                    level = ErrorDto.Level.ERROR,
                    code = e.javaClass.simpleName,
                    message = e.localizedMessage,
                )
            ),
        )
        call.respond(response)
    }
}