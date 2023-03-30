//ThisBuild / organization := "com.example"
//ThisBuild / scalaVersion := "2.13.5"
//
//lazy val root = (project in file(".")).settings(
//  name := "red-book",
//  libraryDependencies ++= Seq(
//    // "core" module - IO, IOApp, schedulers
//    // This pulls in the kernel and std modules automatically.
//    "org.typelevel" %% "cats-effect" % "3.3.12",
//    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
//    "org.typelevel" %% "cats-effect-kernel" % "3.3.12",
//    // standard "effect" library (Queues, Console, Random etc.)
//    "org.typelevel" %% "cats-effect-std" % "3.3.12",
//    // better monadic for compiler plugin as suggested by documentation
//    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
//    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
//  )
//)

ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"


lazy val `red-book` = (project in file("."))
  .settings(
    scalacOptions ++= Seq("-Vimplicits"),
    addCompilerPlugin(
      "org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full
    ),
    libraryDependencies ++= {
      val log4CatsV = "2.5.0"
      val refinedV = "0.10.1"
      val circeV = "0.14.3"
      val newtypesV = "0.2.3"
      val catsEffectV = "3.4.5"

      Seq(
        "org.typelevel" %% "cats-effect" % catsEffectV,
        "org.typelevel" %% "log4cats-slf4j" % log4CatsV,
        "org.typelevel" %% "scalacheck-effect-munit" % "2.0.0-M2" % Test,
        "org.typelevel" %% "log4cats-testing" % log4CatsV % Test,
        "eu.timepit" %% "refined" % refinedV,
        "eu.timepit" %% "refined-scalacheck" % refinedV % Test,
        "io.circe" %% "circe-literal" % circeV % Test,
        "io.circe" %% "circe-refined" % circeV,
        "io.circe" %% "circe-testing" % circeV % Test,
        "io.monix" %% "newtypes-core" % newtypesV,
        "io.monix" %% "newtypes-circe-v0-14" % newtypesV,
        "io.circe" %% "circe-optics" % "0.14.1" % Test,
      )
    }
  )
