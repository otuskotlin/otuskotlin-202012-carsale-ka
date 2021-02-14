package ru.otus.otuskotlin.carsale.backend.common.model

data class CarBrand (
    var id: String = "",
    var name: String = "",
) {
    companion object {
        val NONE = CarBrand()
    }
}