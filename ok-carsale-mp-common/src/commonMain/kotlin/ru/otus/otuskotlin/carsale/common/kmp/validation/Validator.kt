package ru.otus.otuskotlin.carsale.common.kmp.validation

interface Validator<T> {
    infix fun validate(arg: T): ValidationResult
}
