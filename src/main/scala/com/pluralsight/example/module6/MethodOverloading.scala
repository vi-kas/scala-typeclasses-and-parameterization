package com.pluralsight.example.module6

object MethodOverloading {

  def combine(a: Int, b: Int): Int = a + b

  def combine(a: String, b: String): String = s"$a$b"

  def combine[T](a: List[T], b: List[T]): List[T] = a ++ b

  def main(args: Array[String]): Unit = {
    val intCombined = combine(1, 2)
    val stringCombined = combine("Hello", " World")
    val listCombined = combine(List(1, 2), List(3, 4))

    println(intCombined)
    println(stringCombined)
    println(listCombined)
  }
}
