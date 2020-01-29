package com.thibaultdelor


import sbt.Keys._
import sbt._

object MyWrapperPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin

  override def trigger: PluginTrigger = allRequirements


  object autoImport {
    val CliConfig : Configuration = config("myConfig")
    val runCli = taskKey[Unit]("Run the CLI App")
  }

  import autoImport._

  override def projectConfigurations: Seq[Configuration] = Seq(CliConfig)

  override lazy val projectSettings = Seq(
    ivyConfigurations += CliConfig,
    runCli := runIt.value,
    libraryDependencies ++= Seq(
      "com.thibaultdelor" % "mycli_2.11" %  "0.0.1" % CliConfig
    )
  )

  lazy val runIt =
    Def.task {
      val dependencies = (update in CliConfig).value
      val process = Fork.java.fork(
        Compat.forkOptions(bootJars = dependencies.allFiles),
        Seq("com.thibaultdelor.Hello")
      )
      if(process.exitValue() != 0) {
          throw new sbt.MessageOnlyException("Error happened when trying to call the cli")
      }

    }

}
