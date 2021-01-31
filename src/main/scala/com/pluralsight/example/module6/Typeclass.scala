package com.pluralsight.example.module6

object Typeclass {

  trait Combiner[T]{
    def combine(a: T, b: T): T
  }

  object Combiner {
    implicit val intCombiner: Combiner[Int] = (a: Int, b: Int) => a + b

    implicit val stringCombiner: Combiner[String] = (a: String, b: String) => s"$a$b"

    implicit def listCombiner[T]: Combiner[List[T]] = (a: List[T], b: List[T]) => a ++ b
  }

  object CombinerOps {
    //def combine[T](a: T, b: T)(implicit ev: Combiner[T]): T = ev.combine(a, b)

    def combine[T: Combiner](a: T, b: T): T = implicitly[Combiner[T]].combine(a, b)

    def combine[T](a: T, b: T, c: T)(implicit ev: Combiner[T]): T = combine(a, combine(b, c))

    implicit class CombinerExt[T](pair: (T, T)){
      def combine(implicit ev: Combiner[T]): T = ev.combine(pair._1, pair._2)
    }
  }

  object MyCombiner {
    implicit val myStringCombiner: Combiner[String] = (a: String, b: String) => s"$a, $b"
  }

  def main(args: Array[String]): Unit = {
    import CombinerOps._
    import MyCombiner.myStringCombiner

//    val intCombined = combine(1, 2)
    val intCombined = combine(1, 2, 3)
//    val stringCombined = combine("Hello", "World")
    val stringCombined = ("Hello", "World").combine
    val listCombined = combine(List("Ad", "hoc"), List("Polymorphism"))

    println(intCombined)
    println(stringCombined)
    println(listCombined)

  }
}