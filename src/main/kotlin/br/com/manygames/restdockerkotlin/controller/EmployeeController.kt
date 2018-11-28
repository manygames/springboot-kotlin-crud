package br.com.manygames.restdockerkotlin.controller

import br.com.manygames.restdockerkotlin.model.Employee
import br.com.manygames.restdockerkotlin.model.EmployeeUpdateReq
import br.com.manygames.restdockerkotlin.service.DepartmentService
import br.com.manygames.restdockerkotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController {

    @Autowired
    lateinit var employeeService: EmployeeService
    @Autowired
    lateinit var departmentService: DepartmentService

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEmployee(@RequestBody employee: Employee) {
        employeeService.createEmplyee(employee)
    }

    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: Int) = employeeService.getEmployee(id)

    @GetMapping("/employee")
    fun getEmployees(@RequestParam("minAge", required = false) minAge: Int?,
                     @RequestParam("minSalary", required = false) minSalary: Double?) = employeeService.getAllEmployees(minAge, minSalary)

    @GetMapping("/departments")
    fun getAllDepartments() = departmentService.getAllDepartments()

    @PutMapping("/employee/{id}")
    fun updateEmployee(@PathVariable id: Int, @RequestBody updateEmployee: EmployeeUpdateReq) {
        employeeService.updateEmployee(id, updateEmployee)
    }

    @DeleteMapping("/employee/{id}")
    fun deleteEmployee(@PathVariable id: Int): ResponseEntity<String> {
        employeeService.deleteEmployee(id)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build<String>()
    }
}