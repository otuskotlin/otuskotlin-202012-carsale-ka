package ru.otus.otuskotlin.carsale.backend.common.model

import kotlin.math.roundToInt

private const val MILE_AT_KILOMETER = 0.621371

data class Meters(val value: Int) {
    fun toKilometers() = Kilometers((value * 0.001).roundToInt())
    fun toMiles() = toKilometers().toMiles()
}

data class Kilometers(val value: Int) {
    fun toMeters() = Meters(value * 1000)
    fun toMiles() = Miles((value * MILE_AT_KILOMETER).roundToInt())
}

data class Miles(val value: Int) {
    fun toKilometers() = Kilometers(value.div(MILE_AT_KILOMETER).roundToInt())
    fun toMeters() = toKilometers().toMeters()
}
