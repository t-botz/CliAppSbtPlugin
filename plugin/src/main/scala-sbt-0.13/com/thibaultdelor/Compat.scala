package com.thibaultdelor

import sbt.{File, ForkOptions}

object Compat {
  def forkOptions(bootJars: Seq[File]): ForkOptions = {
    ForkOptions(bootJars = bootJars)
  }
}
