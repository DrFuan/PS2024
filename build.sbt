name := """prueba"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.14"

libraryDependencies ++= Seq(
  guice,
  "org.postgresql" % "postgresql" % "42.2.18",
  "io.ebean" % "ebean" % "12.11.2",
  "com.typesafe.play" %% "play-ebean" % "6.0.0",
  "org.scala-lang.modules" %% "scala-xml" % "2.2.0" // Forzamos la versión de scala-xml
)

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

// Solucionamos el conflicto de versiones forzando la versión más reciente de scala-xml
dependencyOverrides += "org.scala-lang.modules" %% "scala-xml" % "2.2.0"
