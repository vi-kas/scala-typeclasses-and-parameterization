package com.pluralsight.example.module4

import java.time.LocalDate

object InvarianceAndContravariance {

  class Employee(val name: String, val dept: String){
    override def toString: String = s"Employee($name, $dept)"
  }

  class ContractEmployee(name: String,
                         dept: String,
                         val contractExpiry: LocalDate) extends Employee(name, dept){
    override def toString: String = s"ContractEmployee($name, $dept, $contractExpiry)"
  }

  class AccessCard[-T](val number: Int)

  def access(accessCard: AccessCard[ContractEmployee]): Unit = {
    //grants access and log card number and timestamp
    println(s"accessCard: ${accessCard.number} used.")
  }

  def main(args: Array[String]): Unit = {

    val contractEmpCard = new AccessCard[ContractEmployee](1)
    access(contractEmpCard)

    val empCard = new AccessCard[Employee](2)
    access(empCard)
  }
}









