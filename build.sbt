name := "mobiquity"

version := "0.1"

scalaVersion := "2.12.4"

parallelExecution in Test := false

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.14.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.3"
