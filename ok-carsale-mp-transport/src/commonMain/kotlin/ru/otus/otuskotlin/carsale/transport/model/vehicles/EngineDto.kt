package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
data class EngineDto (
    val type: EngineTypeDto? = null,
    val volume: Int? = null,
    val powerHP: Int? = null,
)

@Serializable
enum class EngineTypeDto {
    GAZOLINE,
    DIESEL,
    GAZOLINE_BOOSTED,
    DIESEL_BOOSTED,
    ELECTRIC,
}
