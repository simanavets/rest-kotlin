package com.example.restkotlin.service

import com.example.restkotlin.dto.Employee

interface EmployeeService {

    fun getAllEmployees(firstName: String, lastName: String): List<Employee>

    fun getEmployeeById(id: Long): Employee

    fun addEmployee(employee: Employee)

    fun updateEmployee(id: Long, updatedEmployee: Employee)

    fun deleteEmployee(id: Long)

}