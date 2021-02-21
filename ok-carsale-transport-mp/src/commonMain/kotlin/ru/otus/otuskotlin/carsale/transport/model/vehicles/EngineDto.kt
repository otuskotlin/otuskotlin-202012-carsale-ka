package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
enum class EngineDto {
    PETROL,
    DIESEL,
    PETROL_BOOSTED,
    DIESEL_BOOSTED,
    ELECTRIC,
}
