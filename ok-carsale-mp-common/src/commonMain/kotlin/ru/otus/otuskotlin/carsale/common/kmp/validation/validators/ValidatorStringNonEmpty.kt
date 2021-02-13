package ru.otus.otuskotlin.carsale.common.kmp.validation.validators

import ru.otus.otuskotlin.carsale.common.kmp.validation.IValidator
import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationDefaultError
import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationResult

class ValidatorStringNonEmpty: IValidator<String?> {

    override fun validate(sample: String?): ValidationResult {
        return if (sample.isNullOrBlank()) {
            ValidationResult(
                errors = listOf(
                    ValidationDefaultError(
                        message = "String must not be empty",
                    )
                )
            )
        } else {
            ValidationResult.SUCCESS
        }
    }

}
