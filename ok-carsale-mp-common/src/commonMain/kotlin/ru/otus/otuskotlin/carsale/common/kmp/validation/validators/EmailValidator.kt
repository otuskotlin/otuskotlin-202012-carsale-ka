package ru.otus.otuskotlin.carsale.common.kmp.validation.validators

import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationError
import ru.otus.otuskotlin.carsale.common.kmp.validation.Validator
import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationResult

class EmailValidator(
    val field: String = ""
): Validator<String?> {
    private val validatorEmpty = StringNonEmptyValidator()
    private val validatorRegex = StringRegexValidator(
        regex = Regex("""^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}$""", RegexOption.IGNORE_CASE)
    )

    override fun validate(arg: String?): ValidationResult {
        val errors = mutableListOf<ValidationError>()

        errors += validatorEmpty.validate(arg).errors

        if (!arg.isNullOrBlank()) {
            errors += validatorRegex.validate(arg).errors
        }

        return if (errors.isEmpty()) {
            ValidationResult.SUCCESS
        } else {
            ValidationResult(errors)
        }
    }
}
