name := "ScalaFromCSharp"

version := "1.0"

scalaVersion := "2.10.2"

resolvers += "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "latest.integration"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

    