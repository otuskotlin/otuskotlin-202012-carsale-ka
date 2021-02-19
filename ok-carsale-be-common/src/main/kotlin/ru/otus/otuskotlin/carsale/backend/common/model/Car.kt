package ru.otus.otuskotlin.carsale.backend.common.model

data class Car (
    var id: String = "",
    var brand: CarBrand = CarBrand.NONE,
    var model: CarModel = CarModel.NONE,
    var color: CarColor = CarColor.NONE,
)