package ru.otus.otuskotlin.carsale.common.kmp.validation.validators

import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationResult
import ru.otus.otuskotlin.carsale.common.kmp.validation.Validator

class EmailValidator: Validator<String?> {

    private val emptyValidator = StringNonEmptyValidator()
    private val regexValidator = StringRegexValidator(
        regex = Regex("""^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}$""", RegexOption.IGNORE_CASE)
    )

    override fun validate(arg: String?) = ValidationResult(
        emptyValidator.validate(arg).errors,
        arg?.let { regexValidator.validate(arg).errors } ?: emptyList()
    )
}
