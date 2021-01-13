package com.pluralsight.example.module3

object CombinatorMethodFlatMap {

  def filterNonAlphabets(s: String): Option[String] =
    if(s != null)
      Some(s.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
    else None

  def capitalizeWords(s: String): Option[String] =
    if(s != null)
      Some(
        s.split(" ")
          .map(token => token.capitalize)
          .mkString
      )
    else None

  def removeAllSpaces(s: String): Option[String] =
    if(s != null)
      Some(s.replace(" ", ""))
    else None

//  def camelCase(s: String): Option[String] =
//      filterNonAlphabets(s)
//        .flatMap { filtered =>
//          capitalizeWords(filtered)
//            .flatMap { capitalized =>
//              removeAllSpaces(capitalized)
//            }
//        }

  def camelCase(str: String): Option[String] =
    for {
      filtered <- filterNonAlphabets(str)
      capitalized <- capitalizeWords(filtered)
      camelCased <- removeAllSpaces(capitalized)
    } yield  camelCased

  def main(args: Array[String]): Unit = {

    val str = "This is a Demo!!"
    println(camelCase(str))
  }
}