import Dependencies._

ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1-SNAPSHOT"
ThisBuild / organization     := "uk.ac.ed.inf"

ThisBuild / autoAPIMappings  := true

lazy val root = (project in file("."))
  .settings(
    name := "scalevolve",
    libraryDependencies += akkaActor,
    libraryDependencies += scalaTest % Test,
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += akkaTest % Test,
    publishArtifact in Test := true
  )
