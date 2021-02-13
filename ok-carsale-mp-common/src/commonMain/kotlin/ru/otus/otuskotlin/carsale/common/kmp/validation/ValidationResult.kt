package ru.otus.otuskotlin.carsale.common.kmp.validation

data class ValidationResult(val errors: List<ValidationError>) {
    val isSuccess: Boolean
        get() = errors.isEmpty()

    companion object {
        val SUCCESS = ValidationResult(emptyList())

        fun createError(message: String, field: String) =
            ValidationResult(
                errors = listOf(
                    ValidationFieldErrorData(message, field)
                )
            )

        fun createError(message: String) =
            ValidationResult(
                errors = listOf(
                    ValidationDefaultError(message)
                )
            )
    }
}
