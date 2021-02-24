package ru.otus.otuskotlin.carsale.transport.model.common

import kotlinx.datetime.Instant

interface Response {
    val responseId: String?
    val onRequest: String?
    val endTime: Instant?
    val errors: List<ErrorDto>?
    val status: ResponseStatusDto?
    val debug: Debug?
}