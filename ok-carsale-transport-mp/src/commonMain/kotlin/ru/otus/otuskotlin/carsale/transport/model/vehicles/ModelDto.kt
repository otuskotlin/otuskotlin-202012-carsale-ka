package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.carsale.transport.model.common.DataDto

@Serializable
data class ModelDto (
    override val id: String? = null,
    val name: String? = null,
    val brand: BrandDto? = null,
): DataDto