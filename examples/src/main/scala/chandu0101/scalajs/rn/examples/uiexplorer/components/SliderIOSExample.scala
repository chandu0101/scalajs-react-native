package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

object SliderIOSExample extends UIExample {

  case class State(value: Double = 0)

  class Backend(t: BackendScope[_, State]) {
    def handleValueChnage(value: Double): Unit = {
      t.modState(_.copy(value = value))
    }
  }

  val component = ReactNativeComponentB[Unit]("SliderIOSExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
     UIExplorerPage(
       UIExplorerBlock("SliderIOS")(
         View()(
           Text(style = styles.text)(
             S.value
           ),
           SliderIOS(style = styles.slider,
             onValueChange = B.handleValueChnage _)
         )
       )
     )

  }).buildNative

  object styles extends NativeStyleSheet {
    val slider = style(height := 10, margin := 10)

    val text = style(
      fontSize := 14,
      textAlign.center,
      fontWeight._500,
      margin := 10
    )

  }

  override def title: String = "SliderIOS"

  override def description: String = "Slider Example"
}
