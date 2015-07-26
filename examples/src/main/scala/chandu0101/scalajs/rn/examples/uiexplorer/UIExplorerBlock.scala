package chandu0101.scalajs.rn.examples.uiexplorer

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components.{Text, View}
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import japgolly.scalajs.react.ReactNode


object UIExplorerBlock {


  val component = ReactNativeComponentB[String]("UIExplorerBlock")
    .render((P,C) => {
    View(style = styles.container)(
      View(style = styles.titleContainer)(
       Text(style = styles.titleText)(P)
      ),
      View(style = styles.children)(
       C
      )
    )
  }).build

  object styles extends NativeStyleSheet {

    val container = style(
      borderRadius := 3,
      borderWidth := 0.5,
      borderColor := "#d6d7da",
      backgroundColor := "#ffffff",
      margin := 10,
      marginVertical := 5,
      overflow.hidden
    )

    val titleContainer = style(
      borderWidth := 0.5,
      borderColor := "#d6d7da",
      backgroundColor := "#f6f7f8",
      paddingHorizontal := 10,
      paddingVertical := 5
    )

    val titleText = style(fontSize := 14, fontWeight._500)

    val children = style(padding := 10)
  }


  def apply(title: String)(children: ReactNode*) = component(title, children)
}
