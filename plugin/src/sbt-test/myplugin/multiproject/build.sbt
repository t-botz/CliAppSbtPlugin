scalaVersion := "2.11.12"

lazy val p1 = (project in file("project1"))
.settings(
    name := "p1",
    version := "0.1",
    scalaVersion := "2.11.12"

)

lazy val p2 = (project in file("project2"))
  .settings(
    name := "p2",
    version := "0.1",
    scalaVersion := "2.11.12"
  )