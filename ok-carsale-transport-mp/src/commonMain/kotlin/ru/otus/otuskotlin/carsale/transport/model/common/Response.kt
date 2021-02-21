package ru.otus.otuskotlin.carsale.transport.model.common

interface Response {
    val responseId: String?
    val onRequest: String?
    val endTime: String?
    val errors: List<ErrorDto>?
    val status: ResponseStatusDto?
    val debug: IDebug?
}