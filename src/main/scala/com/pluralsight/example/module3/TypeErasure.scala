package com.pluralsight.example.module3

object TypeErasure {

  def listOf[T](list: List[T]): String = {
    list match {
      case ofInt: List[Int] =>"Integer"
      case ofString: List[String] => "String"
      case _ => "Any"
    }
  }

  def main(args: Array[String]): Unit = {

    val numbers = List(1, 2, 3)
    println(listOf(numbers))

    val words = List("one", "two", "three")
    println(listOf(words))
  }
}