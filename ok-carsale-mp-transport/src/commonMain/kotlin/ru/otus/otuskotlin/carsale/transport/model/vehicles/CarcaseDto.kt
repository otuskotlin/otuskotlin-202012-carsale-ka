package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
enum class CarcaseDto {
    COUPE,
    SEDAN,
    LIFTBACK,
    HATCHBACK,
    STATION_WAGON,
}