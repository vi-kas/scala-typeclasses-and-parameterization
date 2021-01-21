package com.pluralsight.example.module4

import java.time.LocalDate

object Covariance {

  class Employee(val name: String, val dept: String){
    override def toString: String = s"Employee($name, $dept)"
  }

  class ContractEmployee(name: String,
                         dept: String,
                         val contractExpiry: LocalDate) extends Employee(name, dept){
    override def toString: String = s"ContractEmployee($name, $dept, $contractExpiry)"
  }

  def employeePerDepartment(list: List[Employee]): Map[String, List[Employee]] =
    list.groupBy(e => e.dept)

  def main(args: Array[String]): Unit = {
    val emp1 = new Employee("Robin", "HR")
    val emp2 = new Employee("Barney", "HR")
    val emp3 = new Employee("Ted", "Tech")
    val employees = List(emp1, emp2, emp3)

    val result1 = employeePerDepartment(employees)
    //println(result1)

    val emp4 =
      new ContractEmployee("Lily", "Tech", LocalDate.ofYearDay(2021, 90))
    val emp5 =
      new ContractEmployee("Marshall", "Sales", LocalDate.ofYearDay(2021, 90))
    val contractEmployees = List(emp4, emp5)

    val result2 = employeePerDepartment(contractEmployees)
    println(result2)

  }
}






