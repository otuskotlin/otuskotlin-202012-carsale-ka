package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.model.common.*
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

private interface Model {
    val name: String?
    val brand: BrandDto?
}

@Serializable
data class CreatableModelDto(
    override val name: String? = null,
    override val brand: BrandDto? = null,
): Model, CreatableDataDto

@Serializable
data class UpdatableModelDto(
    override val id: String? = null,
    override val name: String? = null,
    override val brand: BrandDto? = null,
): Model, UpdatableDataDto

@Serializable
data class ModelDto (
    override val id: String? = null,
    override val name: String? = null,
    override val brand: BrandDto? = null,
): Model, DataDto


// Create

@Serializable
data class CreateModelRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: CreatableModelDto? = null,
) : Message(), Request

@Serializable
data class CreateModelResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ModelDto? = null,
) : Message(), Response


// Read

@Serializable
data class ReadModelRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Message(), Request

@Serializable
data class ReadModelResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ModelDto? = null,
) : Message(), Response


// Update

@Serializable
data class UpdateModelRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: UpdatableModelDto? = null,
) : Message(), Request

@Serializable
data class UpdateModelResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ModelDto? = null,
) : Message(), Response


// Delete

@Serializable
data class DeleteModelRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Message(), Request

@Serializable
data class DeleteModelResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: ModelDto? = null,
    val deleted: Boolean? = null,
) : Message(), Response