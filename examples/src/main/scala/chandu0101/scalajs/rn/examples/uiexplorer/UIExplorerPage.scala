package chandu0101.scalajs.rn.examples.uiexplorer

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{keyboardDismissMode, ScrollView, View}
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import japgolly.scalajs.react._


object UIExplorerPage {

  val component = ReactNativeComponentB[Unit]("UIExamplePage")
    .render((P, C) => {
    View(style = styles.container)(
      ScrollView(style = styles.wrapper, keyboardShouldPersistTaps = true,
        keyboardDismissMode = keyboardDismissMode.INTERACTIVE)(
        C
      )
    )
  }).buildU

  object styles extends NativeStyleSheet {

    val container = style(backgroundColor := "#e9eaed",
      flex := 1)

    val wrapper = style(flex := 1)
  }

  def apply(children: ReactNode*) = component(children)
}
