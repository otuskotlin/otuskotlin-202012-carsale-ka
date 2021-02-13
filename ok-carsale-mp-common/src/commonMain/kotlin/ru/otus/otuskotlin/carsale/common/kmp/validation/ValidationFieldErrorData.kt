package ru.otus.otuskotlin.carsale.common.kmp.validation

data class ValidationFieldErrorData(
    override val message: String,
    override val field: String,
) : ValidationFieldError
