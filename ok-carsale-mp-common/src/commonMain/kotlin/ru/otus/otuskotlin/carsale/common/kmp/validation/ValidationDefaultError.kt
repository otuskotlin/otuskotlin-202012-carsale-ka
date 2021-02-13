package ru.otus.otuskotlin.carsale.common.kmp.validation

data class ValidationDefaultError(
    override val message: String,
) : IValidationError
