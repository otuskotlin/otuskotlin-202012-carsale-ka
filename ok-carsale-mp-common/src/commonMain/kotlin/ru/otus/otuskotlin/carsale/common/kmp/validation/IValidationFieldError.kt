package ru.otus.otuskotlin.carsale.common.kmp.validation

interface IValidationFieldError : IValidationError {
    val field: String
}
