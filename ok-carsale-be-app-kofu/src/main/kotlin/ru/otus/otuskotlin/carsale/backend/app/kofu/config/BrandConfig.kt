package ru.otus.otuskotlin.carsale.backend.app.kofu.config

import org.springframework.fu.kofu.configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.router
import ru.otus.otuskotlin.carsale.backend.app.kofu.controller.BrandController

val brandConfig = configuration {
    beans {
        bean<BrandController>()
        bean(::brandRoutes)
    }
}

fun brandRoutes(brandController: BrandController) = router {
    accept(MediaType.APPLICATION_JSON).nest {
        path("/brand").nest {
            POST("/list", brandController::list)
            POST("/create", brandController::create)
            POST("/read", brandController::read)
            POST("/update", brandController::update)
            POST("/delete", brandController::delete)
        }
    }
}