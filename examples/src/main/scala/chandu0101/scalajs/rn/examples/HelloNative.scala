package chandu0101.scalajs.rn.examples

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{Text, View}
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js.Dynamic.{literal => json}


object HelloNative {

  val component = ReactNativeComponentB[Unit]("HelloNative")
    .render(P => {
    View(style = Styles.container("red"))(
      Text(style = Styles.text)("Welcome to Scala-JS ReactNative"),
      Text(style = Styles.text)("To get started, edit HelloNative.scala ")
    )
  }).buildU


  object Styles extends NativeStyleSheet {
    def container(color: String) = style(flex := 1,
      alignItems.center,
      justifyContent.center,
      backgroundColor := color)

    val text = style(fontSize := 15, padding := 100, justifyContent.flexEnd)

    val baby = styleE(text, container("d"))(flexDirection.row, justifyContent.spaceAround)
  }

  def apply() = component()
}
