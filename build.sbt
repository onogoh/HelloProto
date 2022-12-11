name := "HelloProto"

version := "0.1"

scalaVersion := "2.13.10"
crossScalaVersions := Seq("2.12.17", "2.13.10")

//idePackagePrefix := Some("com.YAEngineers.Protobuf")

useCoursier := false

lazy val Test = "test"

lazy val settings = Seq(
  scalacOptions ++= Seq(
    "-unchecked",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-deprecation",
    "-encoding",
    "utf8"
  ),
  resolvers ++= Seq(
    "Local Ivy Repository" at "file:///" + Path.userHome.absolutePath + ".ivy2/local",
    "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
//    Resolver.sonatypeOssRepo("releases"),
//    Resolver.sonatypeRepo("snapshots")
  )
)
lazy val assemblySettings = Seq(
  //  assemblyJarName in assembly := name.value + ".jar",
  //  assemblyMergeStrategy in assembly := {
  //    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  //    case _                             => MergeStrategy.first
  //  }
)




lazy val dependencies =
  new {
//    val scalaPBV = "0.11.11"
//
//    val scalaPB = "com.thesamet.scalapb" %% "compilerplugin" % scalaPBV
//
//    "com.thesamet.scalapb" %% "compilerplugin" % scalaPBV
//    val pureconfigV = "0.16.0"
//    val scalatestV = "3.2.9"
//    val scalatestcheckV = "3.2.9.0"
//    val scalacheckV = "1.15.4"
//    val scalaMockV = "5.2.0"
//    val scalameterV = "0.21"
//    val catseffectV = "3.3.12"
//    val Http4sV = "0.23.16" //"1.0.0-M24"
//
//    val CirceV = "0.14.3"
//    val CirceConfV = "0.8.0"
//    val fs2V = "3.1.1"
//    val sl4jV = "2.0.0-alpha7"
//    val logbackV = "1.3.0-alpha16"
//    val log4jV = "2.18.0"
//
//    //    val typesafeConfig = "com.typesafe"               % "config"                   % typesafeConfigV
//    val pureconfig = "com.github.pureconfig" %% "pureconfig" % pureconfigV
//    val scalatest = "org.scalatest" %% "scalatest" % scalatestV
//    val scalatestcheck = "org.scalatestplus" %% "scalacheck-1-15" % scalatestcheckV
//    val scalacheck = "org.scalacheck" %% "scalacheck" % scalacheckV
//    val scalaMock = "org.scalamock" %% "scalamock" % scalaMockV
//    val scalameter = "com.storm-enroute" %% "scalameter" % scalameterV
//    val catseffect = "org.typelevel" %% "cats-effect" % catseffectV
//    val catskernel = "org.typelevel" %% "cats-effect-kernel" % catseffectV
//    val Http4s = "org.http4s" %% "http4s-ember-server" % Http4sV
//    val Http4sClient = "org.http4s" %% "http4s-ember-client" % Http4sV
//    val Http4sCirce = "org.http4s" %% "http4s-circe" % Http4sV
//    val Http4sDSL = "org.http4s" %% "http4s-dsl" % Http4sV
//    val CirceCore = "io.circe" %% "circe-core" %CirceV
//    val Circe = "io.circe" %% "circe-generic" % CirceV
//    val CirceLit = "io.circe" %% "circe-literal" % CirceV
//    //    val CirceConf = "io.circe" %% "circe-config" % CirceConfV
//    val fs2IO =  "co.fs2" %% "fs2-io" % fs2V
//    val sl4j= "org.slf4j" % "slf4j-api" % sl4jV
//    val logback = "ch.qos.logback" % "logback-classic" % logbackV
  }




lazy val globalDependencies = Seq(

//  dependencies.scalaPB

//  dependencies.pureconfig,
//
//  dependencies.catseffect,
//  dependencies.Http4s,
//  dependencies.Http4sCirce,
//  dependencies.Http4sDSL,
//  dependencies.CirceCore,
//  dependencies.Circe,
//  dependencies.CirceLit,
//  //  dependencies.CirceConf,
//  dependencies.fs2IO,
//
//  dependencies.Http4sClient,
//  dependencies.sl4j,
//  dependencies.logback,
//  dependencies.scalaMock % Test,
//  dependencies.scalameter % Test,
//  dependencies.scalatest % Test,
//  dependencies.scalatestcheck % Test,
//  dependencies.scalacheck % Test
)

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"

)

// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto
libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.google.protobuf" % "protobuf-java" % "3.17.3",
// for gRPC
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
"com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
// for JSON conversion
)


lazy val global = project
  .in(file(".")).enablePlugins(ScalafmtPlugin) //.enablePlugins( JavaAppPackaging, GhpagesPlugin, MicrositesPlugin, MdocPlugin) //.disablePlugins(ScalafmtPlugin)
  .settings(scalaVersion := "2.13.10",PB.protocVersion := "3.17.3",
    settings, assemblySettings,scalacOptions += "-target:jvm-1.8",
    libraryDependencies ++= globalDependencies
  )
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
