package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ModelDto")
data class ModelDto (
    val id: String? = null,
    val name: String? = null,
    val brand: BrandDto? = null,
)