//name := "HelloProto"
ThisBuild / organization := "com.YAEngineers"
ThisBuild / version      := "0.1.0"
version := "0.1"

//sbtPlugin := false

ThisBuild / scalaVersion := "2.13.10"
//crossScalaVersions := Seq("2.12.17", "2.13.10")
SettingKey[Option[String]]("ide-package-prefix") := Option("com.YAEngineers.Protobuf")

//idePackagePrefix := Some("com.YAEngineers.Protobuf")
useCoursier := true

lazy val Test = "test"

lazy val settings = Seq(
  scalacOptions ++= Seq(
    "-unchecked",
    "-feature",
    "-deprecation",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-deprecation",
    "-encoding",
    "utf8"
  ),name := "HelloProto",version := "0.1", organization :="com.YAEngineers.Protobuf",autoCompilerPlugins := true,
  resolvers ++= Seq(
    "Local Ivy Repository" at "file:///" + Path.userHome.absolutePath + ".ivy2/local",
    "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
//    Resolver.sonatypeRepo("snapshots")
  )
)
lazy val assemblySettings = Seq(
    assembly/assemblyJarName  := name.value + ".jar",
    assembly/assemblyMergeStrategy := {
      case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
      case x if x.endsWith("META-INF/io.netty.versions.properties") => MergeStrategy.first
      case x =>
        val oldStrategy = (assembly / assemblyMergeStrategy).value
        oldStrategy(x)
    }
)


//Compile /fs2.grpc.codegen

//PB.protocOptions in Compile := Seq("-xyz")
//Compile / PB.targets := Seq(
////  scalapb.gen() -> (Compile /sourceDirectory).value / "scala",
//  scalapb.gen(grpc=false) -> (Compile /sourceManaged).value / "scalapb",
//
//
//)
//Compile/Fs2GrpcPlugin.trigger
// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto
val catseffectV = "3.3.12"
val catseffect = "org.typelevel" %% "cats-effect" % catseffectV

libraryDependencies ++= Seq(
//  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.google.protobuf" % "protobuf-java" % "3.17.3",
// for gRPC
  "org.typelevel" %% "fs2-grpc-runtime" % "2.5.6",

"io.grpc" % "grpc-netty-shaded" % scalapb.compiler.Version.grpcJavaVersion,catseffect,
  "io.grpc" % "grpc-protobuf" % scalapb.compiler.Version.grpcJavaVersion,catseffect,
  "io.grpc" % "grpc-stub" %scalapb.compiler.Version.grpcJavaVersion,catseffect,
//  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
// for JSON conversion
)



lazy val global = project
  .in(file(".")).enablePlugins(ScalafmtPlugin).enablePlugins(Fs2Grpc) //.enablePlugins( JavaAppPackaging, GhpagesPlugin, MicrositesPlugin, MdocPlugin) //.disablePlugins(ScalafmtPlugin)
  .settings(scalaVersion := "2.13.10",PB.protocVersion := "3.17.3",
    settings, assemblySettings,scalacOptions += "-target:jvm-1.8",
//    fs2GrpcOutputPath := (Compile /sourceDirectory).value / "scalapb",
    scalapbCodeGeneratorOptions += CodeGeneratorOption.FlatPackage,
    libraryDependencies ++=Seq()
  )
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
