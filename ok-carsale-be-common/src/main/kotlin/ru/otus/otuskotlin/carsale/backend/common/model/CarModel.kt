package ru.otus.otuskotlin.carsale.backend.common.model

data class CarModel (
    var id: String = "",
    var name: String = "",
) {
    companion object {
        val NONE = CarModel()
    }
}