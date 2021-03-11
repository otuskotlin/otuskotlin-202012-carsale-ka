package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.model.common.*
import ru.otus.otuskotlin.carsale.transport.model.vehicles.ModelDto
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

private interface Contact {
    val name: String?
    val phone: String?
    val email: String?
    val created: Instant?
}

@Serializable
data class CreatableContactDto(
    override val name: String? = null,
    override val phone: String? = null,
    override val email: String? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
    ): Contact, CreatableDataDto

@Serializable
data class UpdatableContactDto(
    override val id: String? = null,
    override val name: String? = null,
    override val phone: String? = null,
    override val email: String? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): Contact, UpdatableDataDto

@Serializable
data class ContactDto(
    override val id: String? = null,
    override val name: String? = null,
    override val phone: String? = null,
    override val email: String? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): Contact, DataDto


// Create

@Serializable
data class CreateContactRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: CreatableContactDto? = null,
) : Message(), Request

@Serializable
data class CreateContactResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ContactDto? = null,
) : Message(), Response


// Read

@Serializable
data class ReadContactRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Message(), Request

@Serializable
data class ReadContactResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ContactDto? = null,
) : Message(), Response


// Update

@Serializable
data class UpdateContactRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: UpdatableContactDto? = null,
) : Message(), Request

@Serializable
data class UpdateContactResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ContactDto? = null,
) : Message(), Response


// Delete

@Serializable
data class DeleteContactRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Message(), Request

@Serializable
data class DeleteContactResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ContactDto? = null,
    val deleted: Boolean? = null,
) : Message(), Response


// List

@Serializable
data class ListContactRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
) : Message(), Request

@Serializable
data class ListContactResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: List<ContactDto>? = null,
) : Message(), Response