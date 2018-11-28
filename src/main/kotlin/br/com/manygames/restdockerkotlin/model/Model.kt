package br.com.manygames.restdockerkotlin.model

data class Employee(val id: Int,
                 val name: String,
                 val age: Int,
                 val department: String,
                 val salary: Double): Any()

data class EmployeeUpdateReq(val department: String?, val salary: Double?)