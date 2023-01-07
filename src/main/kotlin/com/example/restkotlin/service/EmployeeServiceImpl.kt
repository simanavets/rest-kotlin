package com.example.restkotlin.service

import com.example.restkotlin.dao.EmployeeRepository
import com.example.restkotlin.dto.Employee
import com.example.restkotlin.exception.EmployeeServiceNotFoundException
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(val repository: EmployeeRepository) : EmployeeService {

    override fun getAllEmployees(firstName: String, lastName: String): List<Employee> {
        return repository.findAllByFirstNameContainingAndLastNameContaining(firstName, lastName)
    }

    override fun getEmployeeById(id: Long): Employee {
        return repository.findById(id)
            .orElseThrow { EmployeeServiceNotFoundException("There is no employee with id = $id") }
    }


    override fun addEmployee(employee: Employee) {
        repository.save(employee)
    }

    override fun updateEmployee(id: Long, updatedEmployee: Employee) {
        val employee = repository.findById(id)
            .orElseThrow { EmployeeServiceNotFoundException("There is no employee with id = $id") }

        employee.firstName = updatedEmployee.firstName
        employee.lastName = updatedEmployee.lastName
        employee.departmentId = updatedEmployee.departmentId
        employee.jobTitle = updatedEmployee.jobTitle

        repository.save(employee)
    }

    override fun deleteEmployee(id: Long) {
        repository.findById(id).ifPresent { repository.deleteById(id) }
    }

}