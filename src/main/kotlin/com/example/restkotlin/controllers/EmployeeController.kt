package com.example.restkotlin.controllers

import com.example.restkotlin.dto.Employee
import com.example.restkotlin.service.EmployeeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Positive

@RestController
@Validated
@RequestMapping("/employees")
class EmployeeController(@Autowired val employeeService: EmployeeService) {

    val logger: Logger = LoggerFactory.getLogger(EmployeeController::class.java)

    @GetMapping
    fun getALLEmployees(
        @RequestParam(name = "first_name", defaultValue = "") firstName: String,
        @RequestParam(name = "last_name", defaultValue = "") lastName: String,
    ): List<Employee?> {
        logger.info("Method getAllEmployees() takes firstName = $firstName, lastName = $lastName")
        return employeeService.getAllEmployees(firstName, lastName)
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@Positive(message = "Id should be greater than zero") @PathVariable id: Long): Employee {
        logger.info("Method getEmployeeById() takes id = $id")
        return employeeService.getEmployeeById(id)
    }

    @PostMapping
    fun addEmployee(@RequestBody employee: Employee) {
        logger.info("Method addEmployee takes employee $employee")
        employeeService.addEmployee(employee)
    }

    @PutMapping("/{id}")
    fun updateEmployee(
        @Positive(message = "Id should be greater than zero") @PathVariable id: Long,
        @RequestBody updatedEmployee: Employee,
    ) {
        logger.info("Method updateEmployee() takes id = {}, employee $updatedEmployee")
        employeeService.updateEmployee(id, updatedEmployee)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@Positive(message = "Id should be greater than zero") @PathVariable id: Long) {
        logger.info("Method deleteEmployee() takes id = $id")
        employeeService.deleteEmployee(id)
    }
}