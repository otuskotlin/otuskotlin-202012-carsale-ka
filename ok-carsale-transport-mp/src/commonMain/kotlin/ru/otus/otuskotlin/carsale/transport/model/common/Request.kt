package ru.otus.otuskotlin.carsale.transport.model.common

interface Request {
    val requestId: String?
    val onResponse: String?
    val startTime: String?
    val debug: IDebug?
}
