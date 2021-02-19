package ru.otus.otuskotlin.carsale.common.kmp.validation

import ru.otus.otuskotlin.carsale.common.kmp.validation.validators.EmailValidator
import ru.otus.otuskotlin.carsale.common.kmp.validation.validators.IntInRangeValidator
import ru.otus.otuskotlin.carsale.common.kmp.validation.validators.StringNonEmptyValidator
import runBlockingTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ValidationTest {

    @Test
    fun createValidationTest() = runBlockingTest {
        val validator = StringNonEmptyValidator()
        val res = validator validate ""
        assertFalse(res.isSuccess)
        assertTrue {
            res.errors.first().message.contains("empty")
        }
    }

    @Test
    fun infixValidationTest() = runBlockingTest {
        val validator = IntInRangeValidator("age", 2, 5)
        val res = validator validate 8
        assertFalse(res.isSuccess)
        assertTrue {
            res.errors.first().message.contains("range")
        }
    }

    @Test
    fun emptyEmailValidationTest() = runBlockingTest {
        val validator = EmailValidator()
        val res = validator validate ""
        assertFalse(res.isSuccess)
        assertTrue {
            res.errors.first().message.contains("empty")
        }
    }

    @Test
    fun wrongEmailValidationTest() = runBlockingTest {
        val validator = EmailValidator()
        val res = validator validate "bad"
        assertFalse(res.isSuccess)
        assertTrue {
            res.errors.first().message.contains("inappropriate")
        }
    }

    @Test
    fun emailValidationTest() = runBlockingTest {
        val validator = EmailValidator()
        val res = validator validate "email@mail.ru"
        assertTrue(res.isSuccess)
    }
}

