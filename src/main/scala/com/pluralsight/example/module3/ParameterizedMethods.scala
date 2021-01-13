package com.pluralsight.example.module3

object ParameterizedMethods {

  def add(a: Int, b: Int): Int = a + b
  def sub(a: Int, b: Int): Int = a - b

  def operation(a: Int, b: Int, op: (Int, Int) => Int): Int = op(a, b)

  def operationP[T](a: T, b: T, op: (T, T) => T): T = op(a, b)

  def main(args: Array[String]): Unit = {

    val addition = operation(2, 1, add)
    val subtraction = operation(2, 1, sub)

    val intAddition: Int = operationP(22, 11, (a: Int, b: Int) => a + b)
    val longAddition: Long = operationP(22L, 11L, (a: Long, b: Long) => a + b)

    println(s"Calling add op for Int => $intAddition")
    println(s"Calling add op for Long => $longAddition")

  }
}