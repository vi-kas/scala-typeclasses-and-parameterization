package com.pluralsight.example.module5

object ImplicitClass {

  sealed trait Currency
  object Currency {
    case object SGD extends Currency
    case object INR extends Currency
    case object USD extends Currency

    type SGD = SGD.type
    type USD = USD.type
    type INR = INR.type
  }

  case class Amount[T <: Currency](value: Double, currency: T)

  implicit class AmountExt[T <: Currency](amt: Amount[T]){
    def +(that: Amount[T]): Amount[T] = amt.copy(value = amt.value + that.value)
  }

  import Currency._

  def addAmounts[T <: Currency](amt1: Amount[T], amt2: Amount[T]): Amount[T] =
    Amount(amt1.value + amt2.value, amt1.currency)

  implicit class AmountDouble(d: Double){
    def usd: Amount[USD] = Amount(d, USD)
  }

  import scala.language.postfixOps

  def main(args: Array[String]): Unit = {
    val oneUSD = Amount(1, USD)
    val tenUSD = Amount(10, USD)

    val result = oneUSD + tenUSD
    //println(result)

    val twoUSD = 2 usd

    val result1 = (3 usd) + (4 usd)
    println(result1)

    //println(twoUSD)

    //println(addAmounts(oneUSD, tenUSD))
  }
}