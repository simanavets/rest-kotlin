package com.example.restkotlin.dto

import com.example.restkotlin.validation.ValidAge
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    var firstName: String,
    var lastName: String,
    var departmentId: Int,
    @Enumerated(EnumType.STRING) var jobTitle: JobTitle,
    @Enumerated(EnumType.STRING) val gender: Gender,
    @ValidAge val birthDate: LocalDate,
)

enum class JobTitle {
    HR, DEVELOPER, SEO, QA
}

enum class Gender {
    MALE, FEMALE
}
