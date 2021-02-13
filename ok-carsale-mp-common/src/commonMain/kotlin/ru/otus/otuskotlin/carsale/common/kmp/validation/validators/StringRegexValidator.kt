package ru.otus.otuskotlin.carsale.common.kmp.validation.validators

import ru.otus.otuskotlin.carsale.common.kmp.validation.ValidationResult
import ru.otus.otuskotlin.carsale.common.kmp.validation.Validator

class StringRegexValidator(
    private val regex: Regex,
): Validator<String> {

    override fun validate(arg: String) =
        regex.replace(arg, "").let {
            if (it.isNotEmpty()) {
                ValidationResult.createError("Field contains inappropriate characters: '$it'")
            } else {
                ValidationResult.SUCCESS
            }
        }
}
