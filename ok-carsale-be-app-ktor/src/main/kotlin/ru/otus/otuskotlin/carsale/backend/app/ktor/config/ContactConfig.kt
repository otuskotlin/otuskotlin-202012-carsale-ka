package ru.otus.otuskotlin.carsale.backend.app.ktor.config

import io.ktor.routing.*
import ru.otus.otuskotlin.carsale.backend.app.ktor.controller.ContactController

fun Route.contactRoute() {
    val contactController = ContactController()

    route("/contact") {
        post("/list") { contactController.list(this) }
        post("/create") { contactController.create(this) }
        post("/read") { contactController.read(this) }
        post("/update") { contactController.update(this) }
        post("/delete") { contactController.delete(this) }
    }
}