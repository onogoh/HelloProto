//addSbtPlugin("com.thesamet" % "sbt-protoc" % "1.0.6")
addSbtPlugin("org.typelevel" % "sbt-fs2-grpc" % "2.5.6")

//addSbtPlugin("org.lyranthe.fs2-grpc" % "sbt-java-gen" % "1.0.1")

libraryDependencies += "org.typelevel" %% "fs2-grpc-codegen" % "2.5.6"

//libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.11.11"