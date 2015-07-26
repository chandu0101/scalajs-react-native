import com.typesafe.sbt.pgp.PgpKeys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object ScalajsReactNative extends Build {

  import Dependencies._

  val Scala211 = "2.11.7"

  type PE = Project => Project

  def commonSettings: PE =
    _.enablePlugins(ScalaJSPlugin)
      .settings(
        organization       := "com.github.chandu0101.scalajs-react-native",
        version            := "0.0.2-SNAPSHOT",
        homepage           := Some(url("https://github.com/chandu0101/scalajs-react-native")),
        licenses           += ("Apache-2.0", url("http://opensource.org/licenses/Apache-2.0")),
        scalaVersion       := Scala211,
        scalacOptions     ++= Seq("-deprecation", "-unchecked", "-feature",
                                "-language:postfixOps", "-language:implicitConversions",
                                "-language:higherKinds", "-language:existentials"))

  def preventPublication: PE =
    _.settings(
      publishArtifact := false,
      publishLocalSigned := (),       // doesn't work
      publishSigned := (),            // doesn't work
      packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42

  def publicationSettings: PE =
    _.settings(
      publishTo := {
        val nexus = "https://oss.sonatype.org/"
        if (isSnapshot.value)
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases"  at nexus + "service/local/staging/deploy/maven2")
      },
      pomExtra :=
        <scm>
          <connection>scm:git:github.com/chandu0101/scalajs-react-native</connection>
          <developerConnection>scm:git:git@github.com:chandu0101/scalajs-react-native.git</developerConnection>
          <url>github.com:chandu0101/scalajs-react-native.git</url>
        </scm>
        <developers>
          <developer>
            <id>chandu0101</id>
            <name>Chandra Sekhar Kode</name>
          </developer>
        </developers>)
    .configure(sourceMapsToGithub)

  def sourceMapsToGithub: PE =
    p => p.settings(
      scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
        val a = p.base.toURI.toString.replaceFirst("[^/]+/?$", "")
        val g = "https://raw.githubusercontent.com/chandu0101/scalajs-react-native"
        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
      }))
    )

     // ==============   react-native tasks ============ //
    val fullOptIOS = Def.taskKey[File]("Generate the file given to react native")

    def createLauncher(scope: String = "compile"): PE =
    _.settings(
      artifactPath in Compile in fullOptIOS :=
        baseDirectory.value / "index.ios.js",
      fullOptIOS in Compile := {
        val outFile = (artifactPath in Compile in fullOptIOS).value

        IO.copyFile((fullOptJS in Compile).value.data, outFile)

        val launcher = (scalaJSLauncher in Compile).value.data.content
        IO.append(outFile, launcher)

        outFile
      }
    )

  def addCommandAliases(m: (String, String)*) = {
    val s = m.map(p => addCommandAlias(p._1, p._2)).reduce(_ ++ _)
    (_: Project).settings(s: _*)
  }

  def extModuleName(mname: String): PE =
    _.settings(name := mname)

  // ========================================= Module Definitions ====================== /
  lazy val root = Project("root", file("."))
    .aggregate(core,styles, examples)
    .configure(commonSettings, preventPublication, addCommandAliases(
      "t"  -> "; test:compile ; test/test",
      "tt" -> ";+test:compile ;+test/test",
      "T"  -> "; clean ;t",
      "TT" -> ";+clean ;tt"))

  lazy val core = project
    .configure(commonSettings, publicationSettings)
    .settings(name := "core")
    .settings(coreModuleDeps :_*)

  lazy val styles = project
    .configure(commonSettings, publicationSettings,extModuleName("styles"))

  lazy val examples = project
    .dependsOn(core,styles)
    .configure(commonSettings,createLauncher(), preventPublication)
    .settings(exampleModuleDeps :_*)

}