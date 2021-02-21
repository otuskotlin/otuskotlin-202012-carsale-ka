package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BrandDto")
data class BrandDto (
    val id: String? = null,
    val name: String? = null,
)