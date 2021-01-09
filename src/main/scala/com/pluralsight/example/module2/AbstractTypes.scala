package com.pluralsight.example.module2

object AbstractTypes {

  abstract class OptionP[T]{
    def isDefined: Boolean

    def get: T
  }

  case class SomeP[T](value: T) extends OptionP[T] {
    override def isDefined: Boolean = true

    override def get: T = value
  }

  case object NoneP extends OptionP[Nothing]{
    override def isDefined: Boolean = false

    override def get: Nothing = throw new NoSuchElementException("get call on None")
  }

  abstract class Option {
    type T

    def isDefined: Boolean
    def get: T
  }

  abstract class Some extends Option {
    type T

    val value: T

    val isDefined = true
    override def get: T = value
  }

  case object None extends Option {
    type T = Nothing

    val isDefined = false
    def get: Nothing = throw new NoSuchElementException("get call on None")
  }

  def size(option: Option): Int = if(option.isDefined) 1 else 0

  def sizeP(option: OptionP[_]): Int = if(option.isDefined) 1 else 0

  def main(args: Array[String]): Unit = {

    val one: Some { type T = Int} =
      new Some {
        type T = Int
        val value: T = 1
      }

    println("one is: " + one.get)
    println("one's size is: " + size(one))
    println("None's size is: " + size(None))
  }

}