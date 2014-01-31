
seq(webSettings :_*)

name := "scala-jspservlet-dummy-project"

version := "v2014-01-30"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature" )


libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container",
  "org.eclipse.jetty" % "jetty-plus"   % "9.1.0.v20131115" % "container"
)

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies ++= Seq(
    "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
    "org.scalatest" %% "scalatest" % "2.0" % "test",
    "junit" % "junit" % "4.+" % "test"
)

initialCommands in console := """import dummy._"""

sourceGenerators in Compile <+= 
 (sourceManaged in Compile, version, name) map {
  (dir, version, projectname) =>
  val file = dir / "dummy" / "MetaInfo.scala"
  IO.write(file,
  """package dummy
    |object MetaInfo { 
    |  val version="%s"
    |  val project="%s"
    |}
    |""".stripMargin.format(version, projectname) )
  Seq(file)
}
