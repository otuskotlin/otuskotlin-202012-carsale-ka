package ru.otus.otuskotlin.carsale.backend.app.ktor.config

import io.ktor.routing.*
import ru.otus.otuskotlin.carsale.backend.app.ktor.controller.ModelController

fun Route.modelRoute() {
    val modelController = ModelController()

    route("/model") {
        post("/list") { modelController.list(this) }
        post("/create") { modelController.create(this) }
        post("/read") { modelController.read(this) }
        post("/update") { modelController.update(this) }
        post("/delete") { modelController.delete(this) }
    }
}