package ru.otus.otuskotlin.carsale.backend.app.kofu.config

import org.springframework.fu.kofu.configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.router
import ru.otus.otuskotlin.carsale.backend.app.kofu.controller.ModelController

val modelConfig = configuration {
    beans {
        bean<ModelController>()
        bean(::modelRoutes)
    }
}

fun modelRoutes(modelController: ModelController) = router {
    accept(MediaType.APPLICATION_JSON).nest {
        path("/model").nest {
            POST("/list", modelController::list)
            POST("/create", modelController::create)
            POST("/read", modelController::read)
            POST("/update", modelController::update)
            POST("/delete", modelController::delete)
        }
    }
}