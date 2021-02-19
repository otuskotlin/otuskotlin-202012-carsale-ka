package ru.otus.otuskotlin.carsale.common.kmp.validation.validators

import ru.otus.otuskotlin.carsale.common.kmp.validation.Validator
import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationResult

class StringNonEmptyValidator: Validator<String?> {

    override fun validate(arg: String?) =
        if (arg.isNullOrBlank()) {
            ValidationResult.createError("String must not be empty")
        } else {
            ValidationResult.SUCCESS
        }
}
