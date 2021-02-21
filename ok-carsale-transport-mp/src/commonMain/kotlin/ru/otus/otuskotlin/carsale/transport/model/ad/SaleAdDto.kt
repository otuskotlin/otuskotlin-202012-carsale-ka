package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.model.common.InstantSerializer
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

@Serializable
@SerialName("SaleAdDto")
data class SaleAdDto (
    val id: String? = null,
    val contact: ContactDto? = null,
    val vin: String? = null,
    val model: ModelDto? = null,
    val year: Int? = null,
    val mileage: Int? = null,
    val carcase: CarcaseDto? = null,
    val color: ColorDto? = null,
    val engineVolume: Int? = null,
    val powerHP: Int? = null,
    val engine: EngineDto? = null,
    val gearbox: GearboxDto? = null,
    val drive: DriveDto? = null,
    val steeringWheel: SteeringWheelDto? = null,
    val price: Int? = null,
    @Serializable(with = InstantSerializer::class) val created: Instant? = null,
)