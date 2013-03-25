
seq(webSettings :_*)

name := "scala-jspservlet-dummy-project"

version := "v2013-03-25"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature" )


libraryDependencies ++= Seq(
     "org.mortbay.jetty" % "jetty" % "6.1.26" % "container"
    ,"org.mortbay.jetty" % "jsp-2.1-glassfish" % "9.1.1.B60.25.p2" % "container"
)

libraryDependencies ++= Seq(
    "ch.qos.logback" % "logback-classic" % "1.0.10",
    "org.scalatest" %% "scalatest" % "1.9.+" % "test",
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
