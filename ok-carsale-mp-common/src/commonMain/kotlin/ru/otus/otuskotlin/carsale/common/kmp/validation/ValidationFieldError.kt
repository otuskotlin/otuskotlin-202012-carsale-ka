package ru.otus.otuskotlin.carsale.common.kmp.validation

interface ValidationFieldError : ValidationError {
    val field: String
}
