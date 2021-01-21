package com.pluralsight.example.module4

import java.time.LocalDate

object TypeBounds {

  class Employee(val name: String, val dept: String){
    override def toString: String = s"Employee($name, $dept)"
  }

  class ContractEmployee(name: String,
                         dept: String,
                         val contractExpiry: LocalDate) extends Employee(name, dept){
    override def toString: String = s"ContractEmployee($name, $dept, $contractExpiry)"
  }

  class AccessCard[-T <: Employee](val number: Int)

  def access[T >: ContractEmployee <: Employee](accessCard: AccessCard[T]): Unit = {
    //grants access and log card number and timestamp
    println(s"accessCard: ${accessCard.number} used.")
  }

  def main(args: Array[String]): Unit = {
    val contractEmpCard: AccessCard[ContractEmployee] = new AccessCard[ContractEmployee](1)
    access(contractEmpCard)

    val empCard: AccessCard[Employee] = new AccessCard[Employee](2)
    access(empCard)

    //val unwantedAccessCard = new AccessCard[Boolean](3)
  }
}
