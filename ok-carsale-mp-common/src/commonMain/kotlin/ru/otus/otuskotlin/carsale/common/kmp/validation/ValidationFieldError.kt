package ru.otus.otuskotlin.carsale.common.kmp.validation

data class ValidationFieldError(
    override val message: String,
    override val field: String,
) : IValidationError, IValidationFieldError
