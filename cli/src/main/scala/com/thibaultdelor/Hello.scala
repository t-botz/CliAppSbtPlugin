package com.thibaultdelor

import scala.util.Properties

object Hello {

  def main(args: Array[String]): Unit = {
    val scalaVersion = Properties.versionNumberString

    //Simulate an app that works only for scala 2.11
    if(scalaVersion.startsWith("2.11")){
      println(s"Hello from $scalaVersion")
    }
    else {
      throw new RuntimeException(s"Scala $scalaVersion unsupported")
    }
  }
}
