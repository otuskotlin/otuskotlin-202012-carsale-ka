package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.serialization.Serializable

@Serializable
enum class DriveDto {
    RWD,
    FWD,
    FULL_TIME_AWD,
    PART_TIME_AWD,
}