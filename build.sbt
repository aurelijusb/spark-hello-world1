name := "Hello spark 1"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.1"

mainClass in (Compile, run) := Some("SimpleApp")