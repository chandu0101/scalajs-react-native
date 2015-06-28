package chandu0101.scalajs.rn.examples.uiexplorer

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{ScrollView, View}
import japgolly.scalajs.react._
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet


object UIExplorerPage {

  val component = ReactNativeComponentB[Unit]("UIExamplePage")
    .render((P,C) => {
       View(style = styles.container)(
        ScrollView(style = styles.wrapper,keyboardShouldPersistTaps = true,keyboardDismissMode = "interactive" )(
          C
        )
       )
  }).buildU

  object styles extends NativeStyleSheet {

    val container = style(backgroundColor := "#e9eaed",
      flex := 1)

    val wrapper = style(flex := 1)
  }

  def apply(children : ReactNode*) = component(children)
}
