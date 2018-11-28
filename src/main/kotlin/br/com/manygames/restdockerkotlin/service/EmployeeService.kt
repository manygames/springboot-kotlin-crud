package br.com.manygames.restdockerkotlin.service

import br.com.manygames.restdockerkotlin.model.Employee
import br.com.manygames.restdockerkotlin.model.EmployeeUpdateReq
import org.springframework.stereotype.Service
import reactor.core.publisher.toFlux

@Service
class EmployeeService {
    companion object {
        val employeeDb = mutableMapOf(
                1 to Employee(1, "Weber", 25, "Engineering", 500.00),
                2 to Employee(2, "Joice", 32, "HR", 600.00))
    }

    fun createEmplyee(employee: Employee) = employeeDb.put(employee.id, employee)

    //employeeDb[id].toMono() doen't work
    fun getEmployee(id: Int) = employeeDb[id]

    fun getAllEmployees(minAge: Int? = null, minSalary: Double? = null)
            = employeeDb.values.toFlux()
                .filter {it.age >= minAge ?: Int.MIN_VALUE}
                .filter {it.salary >= minSalary ?: Double.MIN_VALUE}

    fun updateEmployee(id: Int, updateEmployee: EmployeeUpdateReq) {
        val employeeOnDb = employeeDb[id]!!
        employeeDb[id] = Employee(employeeOnDb.id, employeeOnDb.name, employeeOnDb.age,
                updateEmployee.department ?: employeeOnDb.department, updateEmployee.salary ?: employeeOnDb.salary)
    }

    fun deleteEmployee(id: Int) = employeeDb.remove(id)
}