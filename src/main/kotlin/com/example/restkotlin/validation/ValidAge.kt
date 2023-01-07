package com.example.restkotlin.validation

import java.time.LocalDate
import java.time.Period
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [AgeValidator::class])
annotation class ValidAge(
    val message: String = "Age not valid",
    val lower: Int = 18,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<Any>> = [],
)

class AgeValidator(private var minimumAge: Int = 18) : ConstraintValidator<ValidAge, LocalDate> {

    override fun initialize(validAge: ValidAge) {
        minimumAge = validAge.lower
    }

    override fun isValid(dateOfBirth: LocalDate?, context: ConstraintValidatorContext?): Boolean {
        return Period.between(dateOfBirth, LocalDate.now()).years >= minimumAge
    }
}




