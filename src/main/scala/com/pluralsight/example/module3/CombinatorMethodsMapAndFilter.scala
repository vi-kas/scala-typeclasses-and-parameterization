package com.pluralsight.example.module3

object CombinatorMethodsMapAndFilter {

  def main(args: Array[String]): Unit = {
    val countryNames: List[String] =
      List(
        "Austria", "belgium", "canada", "Denmark", "England",
        "Thailand", "india", "Singapore", "United States",
        "Australia", "china", "germany", "Russia"
      )

    countryNames
      .map(cName => cName.toUpperCase())
      //.foreach(cName => println(cName))

    //def filter(f: T => Boolean): List[T]

    countryNames
      .filter(cName => cName.length == 7)
      .map(cName => cName.toUpperCase())
      .foreach(c => println(c))
  }
}