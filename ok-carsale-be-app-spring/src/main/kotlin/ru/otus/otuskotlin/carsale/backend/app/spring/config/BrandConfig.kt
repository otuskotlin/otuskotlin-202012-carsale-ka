package ru.otus.otuskotlin.carsale.backend.app.spring.config

import org.springframework.fu.kofu.configuration
import org.springframework.web.servlet.function.router
import ru.otus.otuskotlin.carsale.backend.app.spring.controller.BrandController

val brandConfig = configuration {
    beans {
        bean<BrandController>()
        bean(::brandRoutes)
    }
}

fun brandRoutes(brandController: BrandController) = router {
    POST("/brand/list", brandController::list)
    POST("/brand/create", brandController::create)
    POST("/brand/read", brandController::read)
    POST("/brand/update", brandController::update)
    POST("/brand/delete", brandController::delete)
}