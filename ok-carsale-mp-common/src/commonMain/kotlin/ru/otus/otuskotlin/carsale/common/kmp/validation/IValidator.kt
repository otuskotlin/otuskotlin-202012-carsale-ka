package ru.otus.otuskotlin.carsale.common.kmp.validation

interface IValidator<T> {
    infix fun validate(sample: T): ValidationResult
}
