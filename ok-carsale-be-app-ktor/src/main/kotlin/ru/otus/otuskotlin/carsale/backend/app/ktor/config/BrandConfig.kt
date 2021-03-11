package ru.otus.otuskotlin.carsale.backend.app.ktor.config

import io.ktor.routing.*
import ru.otus.otuskotlin.carsale.backend.app.ktor.controller.BrandController

fun Route.brandRoute() {
    val brandController = BrandController()

    route("/brand") {
        post("/list") { brandController.list(this) }
        post("/create") { brandController.create(this) }
        post("/read") { brandController.read(this) }
        post("/update") { brandController.update(this) }
        post("/delete") { brandController.delete(this) }
    }
}