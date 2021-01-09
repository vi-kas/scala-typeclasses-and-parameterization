package com.pluralsight.example.module2

object Pair {

  //Not a scalable Way
  case class IntStringPair(fst: Int, snd: String){

    def switch: StringIntPair = StringIntPair(fst = snd, snd = fst)

    override def toString: String = s"($fst, $snd)"
  }

  case class StringIntPair(fst: String, snd: Int){
    override def toString: String = s"($fst, $snd)"
  }

  //Doesn't give us type information needed
  case class PairAny(fst: Any, snd: Any){

    def switch: PairAny = this.copy(fst = snd, snd = fst)

    override def toString: String = s"($fst, $snd)"
  }

  def main(args: Array[String]): Unit = {

    val intStringPair = PairAny(1, "First")
    println(s"IntStringPair: $intStringPair")

    val switched = intStringPair.switch
    println(s"Switched Pair: $switched")

    // Below line won't compile
    // val first: Int = intStringPair.fst
  }
}