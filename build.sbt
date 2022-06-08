import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val akkaVersion       = "2.6.15"
val akkaHttpVersion   = "10.2.4"
val catsVersion       = "2.6.1"
val circeVersion      = "0.14.1"
val scalatestVersion  = "3.2.9"
val jaxbApiVersion    = "2.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "gaurdrail-feedonomics",
    libraryDependencies += scalaTest % Test
  ).settings(
  openApiInputSpec := "petstore.yaml",
  openApiConfigFile := "config.yaml",
  openApiPackageName := "com.bigcommerce.api.feedonomics"
)

libraryDependencies += "io.swagger.parser.v3" % "swagger-parser-v2-converter" % "2.0.24"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"        % akkaVersion,
  "com.typesafe.akka" %% "akka-stream"       % akkaVersion,
  "com.typesafe.akka" %% "akka-http"         % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
  "io.circe"          %% "circe-core"        % circeVersion,
  "io.circe"          %% "circe-generic"     % circeVersion,
  "io.circe"          %% "circe-parser"      % circeVersion,
  "javax.xml.bind"    %  "jaxb-api"          % jaxbApiVersion,
  "org.scalatest"     %% "scalatest"         % scalatestVersion % Test,
  "org.typelevel"     %% "cats-core"         % catsVersion,
)

Compile / guardrailTasks := List(
  //ScalaServer(file("petstore.yaml"), pkg="com.bigcommerce.feedonomics-api.server"),
  ScalaClient(file("petstore.yaml"), pkg="com.bigcommerce.feedonomics-api.client")
)

enablePlugins(AkkaGrpcPlugin)



// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
