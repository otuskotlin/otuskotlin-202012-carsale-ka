package ru.otus.otuskotlin.carsale.backend.common.model

import java.math.BigDecimal
import java.math.RoundingMode

val MILE_AT_KILOMETER: BigDecimal = BigDecimal.valueOf(0.621371)

data class Meters (
    val value: BigDecimal
) {
    constructor (value: Long): this(BigDecimal.valueOf(value))
    constructor (value: Double): this(BigDecimal.valueOf(value))
    fun toKilometers() = value.multiply(BigDecimal.valueOf(0.001)).setScale(1, RoundingMode.HALF_DOWN).let(::Kilometers)
    fun toMiles() = toKilometers().toMiles()
}

data class Kilometers (
    val value: BigDecimal
) {
    constructor (value: Long): this(BigDecimal.valueOf(value))
    constructor (value: Double): this(BigDecimal.valueOf(value))
    fun toMeters() = value.multiply(BigDecimal.valueOf(1000)).let(::Meters)
    fun toMiles() = (value * MILE_AT_KILOMETER).setScale(0, RoundingMode.HALF_UP).let(::Miles)
}

data class Miles (
    val value: BigDecimal
) {
    constructor (value: Long): this(BigDecimal.valueOf(value))
    constructor (value: Double): this(BigDecimal.valueOf(value))
    fun toKilometers() = value.div(MILE_AT_KILOMETER).setScale(0).let(::Kilometers)
    fun toMeters() = toKilometers().toMeters()
}
