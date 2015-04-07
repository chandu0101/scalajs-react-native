package chandu0101.scalajs.rn.examples

import chandu0101.scalajs.rn.components.{Text, View}
import chandu0101.scalajs.rn.{ReactNative, ReactNativeComponentB}

import scala.scalajs.js.Dynamic.{literal => json}


/**
 * Created by chandrasekharkode on 4/7/15.
 */
object HelloNative {

  val component = ReactNativeComponentB[Unit]("HelloNative")
    .render(P => {
    View(style = styles.container)(
       Text(style = styles.text)("Welcome to Scala-JS ReactNative"),
       Text(style = styles.text)("To get started, edit HelloNative.scala ")
    )
  }).buildU

  val styles = ReactNative.StyleSheet.create(
    json(
      container = json(flex = 1,
        alignItems = "center",
        justifyContent = "center",
        backgroundColor = "#F5FCFF"),
      text = json(fontSize = 14,
      padding = 10)
    )
  )

  def apply() = component()
}
