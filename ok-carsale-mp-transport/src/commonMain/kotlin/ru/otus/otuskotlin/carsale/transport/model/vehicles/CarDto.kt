package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
data class CarDto(
    val vin: String? = null,
    val model: ModelDto? = null,
    val year: Int? = null,
    val mileage: Int? = null,
    val carcase: CarcaseDto? = null,
    val color: ColorDto? = null,
    val engine: EngineDto? = null,
    val gearbox: GearboxDto? = null,
    val drive: DriveDto? = null,
    val steeringWheel: SteeringWheelDto? = null,
)
