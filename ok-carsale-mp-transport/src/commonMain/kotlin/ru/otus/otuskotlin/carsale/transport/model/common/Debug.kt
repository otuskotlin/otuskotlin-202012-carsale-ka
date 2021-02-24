package ru.otus.otuskotlin.carsale.transport.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Debug(
    val mode: WorkModeDto? = null,
)
