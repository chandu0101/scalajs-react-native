package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.UIExample
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet


object StatusBarIOSExample extends UIExample {

   val component = ReactNativeComponentB[Unit]("StatusBarIOSExample")
       .render(P => {
       View()()
     }).buildNative

    object styles extends NativeStyleSheet {
     val wrapper = style(
      borderRadius := 5,
      marginBottom := 5
     )

      val button = style(
        backgroundColor := "#eeeeee",
        padding := 10
      )

     }
     override def title: String = "StatusBarIOS"

     override def description: String = "Module for controlling iOS status bar"
}
