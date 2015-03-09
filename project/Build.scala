import sbt._
import sbt.Keys._

import bintray.Plugin._
import bintray.Keys._

object Build extends Build {

  val root = Project("root", file("."))
    .settings(
      name                := "bloom",
      organization        := "com.appdation",
      version             := "0.1.0",
      scalaVersion        := "2.11.2",
      licenses            += ("MIT", url("http://opensource.org/licenses/MIT")),
      scalacOptions       += "-feature",
      scalacOptions       += "-deprecation",
      resolvers           += "Plasma Conduit Repository" at "http://dl.bintray.com/plasmaconduit/releases",
      libraryDependencies += "com.plasmaconduit" %% "waterhouse" % "0.5.0"
    )

}