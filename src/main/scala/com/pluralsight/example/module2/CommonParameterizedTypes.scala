package com.pluralsight.example.module2

//Assuming HttpUtils is defined in some Scala Library
object HttpUtils {

  sealed trait HttpVerb
  case object GET extends HttpVerb
  case object PUT extends HttpVerb
  case object POST extends HttpVerb

  def asHttpVerb(httpVerb: String): HttpVerb =
    httpVerb.toLowerCase match {
      case "get" => GET
      case "post" => POST
      case "put" => PUT
      case other => throw new IllegalArgumentException(s"No equivalent HttpVerb for $other")
    }
}

object CommonParameterizedTypes {
  import scala.util.{Try, Success, Failure}
  import com.pluralsight.example.module2.HttpUtils._

  def main(args: Array[String]): Unit = {

    def toHttpVerb(httpVerb: String): Either[Throwable, HttpVerb] =
      Try {
        HttpUtils.asHttpVerb(httpVerb)
      } match {
        case Success(value) => Right(value)
        case Failure(exception) => Left(exception)
      }

    println(toHttpVerb("get"))
    println(toHttpVerb("got"))
  }
}