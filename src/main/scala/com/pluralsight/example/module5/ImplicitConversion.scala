package com.pluralsight.example.module5

object StringConversions {
  implicit def tokenizer(str: String): List[String] = str.split(" ").toList
}

object ImplicitConversion {

  def capitalizer(words: List[String]): List[String] = words.map(w => w.capitalize)

  import StringConversions._

  def main(args: Array[String]): Unit = {

    val words = List("This", "is", "simply", "awesome")
    //println(capitalizer(words))

    val title = "scala Implicits - why, what and how"
    println(capitalizer(title).mkString(" "))

  }
}