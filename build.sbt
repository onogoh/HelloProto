//name := "HelloProto"

version := "0.1"

//sbtPlugin := false

ThisBuild / scalaVersion := "2.13.10"
//crossScalaVersions := Seq("2.12.17", "2.13.10")

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
    ThisBuild/assemblyJarName  := name.value + ".jar",
  //  assemblyMergeStrategy in assembly := {
  //    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  //    case _                             => MergeStrategy.first
  //  }
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
    libraryDependencies ++=Seq()
  )
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
