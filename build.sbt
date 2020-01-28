lazy val latestScala210 = "2.10.7"
lazy val latestScala211 = "2.11.12"
lazy val latestScala212 = "2.12.8"

lazy val cli = (project in file("cli"))
  .enablePlugins(JavaAppPackaging)
  .settings(
    organization := "com.thibaultdelor",
    version := "0.0.1",
    name := "mycli",
    scalaVersion := latestScala211,
    description := "A CLI on scala 2.11",
    // Add a dependency which is published only on 2.11
    libraryDependencies += "org.apache.spark" %% "spark-tags" % "2.4.4"

  )

lazy val sbtPlugin = (project in file("plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    organization := "com.thibaultdelor",
    version := "0.0.1",
    name := "mysbtplugin",
    scalaVersion := latestScala212,
    description := "A SBT plugin that runs the CLI in its own JVM",
    crossScalaVersions := Seq(latestScala210, latestScala212),
    sbtVersion in pluginCrossBuild := {
      scalaBinaryVersion.value match {
        case "2.10" => "0.13.16"
        case "2.12" => "1.3.7"
        case _ => "1.3.7"
      }
    },
    scriptedLaunchOpts := { scriptedLaunchOpts.value ++
      Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false
  )


lazy val root: Project = Project("all", file("."))
  .settings(
    crossScalaVersions := Nil,
    publishArtifact := false
  )
  .aggregate(cli, sbtPlugin)
