package ru.otus.otuskotlin.carsale.backend.common.model

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class UnitMeasuresTest : StringSpec({

    "it should convert meters to miles (data.forAll)"{
        table(
            headers("meters", "expected miles"),
            row(Kilometers(322), Miles(200)),
            row(Kilometers(150000), Miles(93206)),
            row(Kilometers(10000), Miles(6214)),
        ).forAll { kilometers, expectedMiles -> kilometers.toMiles() shouldBe expectedMiles }
    }

    "it should convert miles to kilometers (inspectors.forAll)"{
        listOf(
            Miles(200) to Kilometers(322),
            Miles(100000) to Kilometers(160934),
        ).forAll { (miles, expectedMeters) ->  miles.toKilometers() shouldBe expectedMeters }
    }
})

class MetersTest : FreeSpec({
    "convert meters to kilometers" - {
        listOf(
            Meters(2000) to Kilometers(2),
            Meters(3100) to Kilometers(3),
            Meters(4999) to Kilometers(5),
            Meters(555) to Kilometers(1),
            Meters(499) to Kilometers(0),
        ).forEach { (meters: Meters, expectedKilometers: Kilometers) ->
            "it should convert $meters to $expectedKilometers"{
                meters.toKilometers() shouldBe expectedKilometers
            }
        }
    }
})
