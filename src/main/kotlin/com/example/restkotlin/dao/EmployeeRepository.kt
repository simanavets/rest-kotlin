package com.example.restkotlin.dao

import com.example.restkotlin.dto.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {

    fun findAllByFirstNameContainingAndLastNameContaining(firstName: String, lastName: String): List<Employee>
}