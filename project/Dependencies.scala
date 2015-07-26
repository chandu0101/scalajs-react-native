import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object Dependencies {

  val scalajsReactVersion = "0.9.1"

  val  scalaAsyncVersion =  "0.9.2"

  val scalaJSReact =  libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion

  val scalaJSReactExtra =  libraryDependencies += "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion

  val scalaAsync = libraryDependencies += "org.scala-lang.modules" %% "scala-async" % scalaAsyncVersion


  val coreModuleDeps = Seq(scalaJSReact,scalaJSReactExtra)

  val exampleModuleDeps = Seq(scalaAsync)

}