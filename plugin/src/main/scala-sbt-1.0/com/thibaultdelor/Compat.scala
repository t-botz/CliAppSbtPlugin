package com.thibaultdelor

import sbt.{File, ForkOptions}

object Compat {

  def forkOptions(bootJars: Vector[File]): ForkOptions = {
    ForkOptions().withBootJars(bootJars)
  }
}
