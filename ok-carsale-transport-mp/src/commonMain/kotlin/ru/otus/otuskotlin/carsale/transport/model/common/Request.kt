package ru.otus.otuskotlin.carsale.transport.model.common

import kotlinx.datetime.Instant

interface Request : Message {
    val requestId: String?
    val onResponse: String?
    val startTime: Instant?
    val debug: Debug?
}
