package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
enum class GearboxDto {
    MANUAL,
    AUTO,
    ROBOT,
    DCT,
    CVT,
}