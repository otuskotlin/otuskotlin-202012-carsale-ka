package ru.otus.otuskotlin.carsale.common.kmp.validation.validators

import ru.otus.otuskotlin.carsale.common.kmp.validation.Validator
import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationResult

class IntInRangeValidator<T : Comparable<T>>(
    private val field: String,
    private val min: T,
    private val max: T
): Validator<T> {
    override fun validate(arg: T): ValidationResult =
        if (arg in min..max) {
            ValidationResult.SUCCESS
        } else {
            ValidationResult.createError(message = "Value $arg for field $field exceeds range [$min, $max]", field)
        }
}
