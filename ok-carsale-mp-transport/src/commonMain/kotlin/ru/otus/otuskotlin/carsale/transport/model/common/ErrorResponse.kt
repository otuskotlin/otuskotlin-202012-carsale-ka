package ru.otus.otuskotlin.carsale.transport.model.common

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

@Serializable
data class ErrorResponse(
    val type: String? = null, /* classDiscriminator */
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
) : Message(), Response
