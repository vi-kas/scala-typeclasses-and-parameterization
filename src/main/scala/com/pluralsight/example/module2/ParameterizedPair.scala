package com.pluralsight.example.module2

object ParameterizedPair {

  case class Pair[T, U](fst: T, snd: U){

    def switch: Pair[U, T] = this.copy(fst = snd, snd = fst)

    override def toString: String = s"($fst, $snd)"
  }

  def main(args: Array[String]): Unit = {

    val intStringPair: Pair[Int, String] = Pair(1, "First")

    val switched = intStringPair.switch

    println(s"IntStringPair: $intStringPair | switched: $switched")

    val first: Int = intStringPair.fst
  }

}