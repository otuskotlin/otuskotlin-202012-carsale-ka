package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.model.common.*
import ru.otus.otuskotlin.carsale.transport.model.vehicles.CarDto
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

private interface SaleAd {
    val contact: ContactDto?
    val car: CarDto?
    val price: Int?
    val created: Instant?
}

@Serializable
data class CreatableSaleAdDto(
    override val contact: ContactDto? = null,
    override val car: CarDto? = null,
    override val price: Int? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): SaleAd, CreatableDataDto

@Serializable
data class UpdatableSaleAdDto(
    override val id: String? = null,
    override val contact: ContactDto? = null,
    override val car: CarDto? = null,
    override val price: Int? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): SaleAd, UpdatableDataDto

@Serializable
data class SaleAdDto (
    override val id: String? = null,
    override val contact: ContactDto? = null,
    override val car: CarDto? = null,
    override val price: Int? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): SaleAd, DataDto


// Create

@Serializable
data class CreateSaleAdRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: CreatableSaleAdDto? = null,
) : Message(), Request

@Serializable
data class CreateSaleAdResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: SaleAdDto? = null,
) : Message(), Response


// Read

@Serializable
data class ReadSaleAdRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Message(), Request

@Serializable
data class ReadSaleAdResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: SaleAdDto? = null,
) : Message(), Response


// Update

@Serializable
data class UpdateSaleAdRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: UpdatableSaleAdDto? = null,
) : Message(), Request

@Serializable
data class UpdateSaleAdResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: SaleAdDto? = null,
) : Message(), Response


// Delete

@Serializable
data class DeleteSaleAdRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Message(), Request

@Serializable
data class DeleteSaleAdResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: SaleAdDto? = null,
    val deleted: Boolean? = null,
) : Message(), Response