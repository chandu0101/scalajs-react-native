package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.UIExample
import chandu0101.scalajs.rn.styles.NativeStyleSheet

object LayoutExample extends UIExample {

  val component = ReactNativeComponentB[Unit]("LayoutExample")
    .render(P => {
    View()()
  }).buildNative

  object styles extends NativeStyleSheet {


  }

  override def title: String = "Layout - Flexbox"

  override def description: String = "Examples of using the flexbox API to layout views."

}
