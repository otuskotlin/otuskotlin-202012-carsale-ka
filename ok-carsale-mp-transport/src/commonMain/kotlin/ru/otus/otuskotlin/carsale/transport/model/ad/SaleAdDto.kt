package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.model.common.*
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

private interface SaleAd {
    val contact: ContactDto?
    val vin: String?
    val model: ModelDto?
    val year: Int?
    val mileage: Int?
    val carcase: CarcaseDto?
    val color: ColorDto?
    val engineVolume: Int?
    val powerHP: Int?
    val engine: EngineDto?
    val gearbox: GearboxDto?
    val drive: DriveDto?
    val steeringWheel: SteeringWheelDto?
    val price: Int?
    val created: Instant?
}

@Serializable
data class CreatableSaleAdDto(
    override val contact: ContactDto? = null,
    override val vin: String? = null,
    override val model: ModelDto? = null,
    override val year: Int? = null,
    override val mileage: Int? = null,
    override val carcase: CarcaseDto? = null,
    override val color: ColorDto? = null,
    override val engineVolume: Int? = null,
    override val powerHP: Int? = null,
    override val engine: EngineDto? = null,
    override val gearbox: GearboxDto? = null,
    override val drive: DriveDto? = null,
    override val steeringWheel: SteeringWheelDto? = null,
    override val price: Int? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): SaleAd, CreatableDataDto

@Serializable
data class UpdatableSaleAdDto(
    override val id: String? = null,
    override val contact: ContactDto? = null,
    override val vin: String? = null,
    override val model: ModelDto? = null,
    override val year: Int? = null,
    override val mileage: Int? = null,
    override val carcase: CarcaseDto? = null,
    override val color: ColorDto? = null,
    override val engineVolume: Int? = null,
    override val powerHP: Int? = null,
    override val engine: EngineDto? = null,
    override val gearbox: GearboxDto? = null,
    override val drive: DriveDto? = null,
    override val steeringWheel: SteeringWheelDto? = null,
    override val price: Int? = null,
    @Serializable(with = InstantSerializer::class) override val created: Instant? = null,
): SaleAd, UpdatableDataDto

@Serializable
data class SaleAdDto (
    override val id: String? = null,
    override val contact: ContactDto? = null,
    override val vin: String? = null,
    override val model: ModelDto? = null,
    override val year: Int? = null,
    override val mileage: Int? = null,
    override val carcase: CarcaseDto? = null,
    override val color: ColorDto? = null,
    override val engineVolume: Int? = null,
    override val powerHP: Int? = null,
    override val engine: EngineDto? = null,
    override val gearbox: GearboxDto? = null,
    override val drive: DriveDto? = null,
    override val steeringWheel: SteeringWheelDto? = null,
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