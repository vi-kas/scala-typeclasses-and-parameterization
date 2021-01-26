package com.pluralsight.example.module5

import java.io.File

object PSFiles {

  def listFiles(implicit dir: String): Unit = {
    val file = new File(dir)
    if(file.isDirectory)
      file.list().foreach(f => println(f))
    else println("empty or no directory")
  }

  def listFilesCount(count: Int)(implicit dir: String): Unit = {
    val file = new File(dir)
    if(file.isDirectory)
      file.list().take(count).foreach(f => println(f))
    else println("empty or no directory")
  }

  object Implicits {
    implicit val current: String = "."
  }
}

object ImplicitParameter {
  import PSFiles.Implicits.current
  import PSFiles._

  def main(args: Array[String]): Unit = {

    listFilesCount(3)
  }
}