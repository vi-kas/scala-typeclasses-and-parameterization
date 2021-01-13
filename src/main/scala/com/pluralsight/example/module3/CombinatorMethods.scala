package com.pluralsight.example.module3

object CombinatorMethods {

  def map[T, U](option: Option[T], f: T => U): Option[U] =
    if(option.isDefined) Some(f(option.get)) else None

  def main(args: Array[String]): Unit = {
    val mayBeString: Option[String] = Some("one")

    val capitalized: Option[String] = map(mayBeString, (s: String) => s.capitalize)
    println(s"Capitalized String => $capitalized")

    val length: Option[Int] = map(mayBeString, (s: String) => s.length)
  }
}
