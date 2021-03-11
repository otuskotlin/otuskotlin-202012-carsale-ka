package ru.otus.otuskotlin.carsale.backend.app.ktor.config

import io.ktor.routing.*
import ru.otus.otuskotlin.carsale.backend.app.ktor.controller.SaleAdController

fun Route.saleAdRoute() {
    val saleAdController = SaleAdController()

    route("/sale-ad") {
        post("/list") { saleAdController.list(this) }
        post("/create") { saleAdController.create(this) }
        post("/read") { saleAdController.read(this) }
        post("/update") { saleAdController.update(this) }
        post("/delete") { saleAdController.delete(this) }
    }
}