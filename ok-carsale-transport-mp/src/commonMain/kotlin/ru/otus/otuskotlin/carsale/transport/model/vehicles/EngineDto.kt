package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
enum class EngineDto {
    GAZOLINE,
    DIESEL,
    GAZOLINE_BOOSTED,
    DIESEL_BOOSTED,
    ELECTRIC,
}
