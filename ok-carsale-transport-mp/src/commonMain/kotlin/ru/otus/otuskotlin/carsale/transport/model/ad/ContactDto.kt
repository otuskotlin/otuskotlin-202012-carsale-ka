package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

@Serializable
@SerialName("ContactDto")
data class ContactDto(
    val id: String? = null,
    val name: String? = null,
    val phone: String? = null,
    val email: String? = null,
    @Serializable(with = InstantSerializer::class) val created: Instant? = null,
)
