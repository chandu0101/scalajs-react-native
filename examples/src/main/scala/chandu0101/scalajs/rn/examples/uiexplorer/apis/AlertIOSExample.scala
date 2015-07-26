package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.apis.AlertButton
import chandu0101.scalajs.rn.components.{Text, TouchableHighlight, View}
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce


object AlertIOSExample extends UIExample {
  override def title: String = "AlertIOS"

  override def component = ReactNativeComponentB[Unit]("AlertIOSExample")
    .render(P => {
    val a1  = () => rn.ReactNative.AlertIOS.alert("Foo title", "alert message")
    val a2 = () => rn.ReactNative.AlertIOS.alert(buttons = js.Array(AlertButton("Button",() => println("Button Pressed")).toJson))
    val a3 = () => rn.ReactNative.AlertIOS.alert(
      title = "Foo Title",
      message = "My Alert Msg" ,
      buttons = js.Array(AlertButton("Foo",() => println("Foo Button Pressed")).toJson,
        AlertButton("Bar",() => println("Bar Button Pressed")).toJson))
    val a4 = () => rn.ReactNative.AlertIOS.alert(
      title = "Foo Title",
      buttons = js.Array(AlertButton("Foo",() => println("Foo Button Pressed")).toJson,
        AlertButton("Bar",() => println("Bar Button Pressed")).toJson,
        AlertButton("Baz",() => println("Baz Button Pressed")).toJson))
    val a5  = () => rn.ReactNative.AlertIOS.alert(title = "Foo title",
    buttons = (1 to 10).map(i => AlertButton(s"Button $i",() => println(s"Button $i pressed")).toJson.asInstanceOf[js.Object]).toJSArray)

    UIExplorerPage(
      UIExplorerBlock("Alerts")(
        View(style = json(flex = 1))(
          TouchableHighlight(style = styles.wrapper, onPress = a1)(
            View(style = styles.button)(
              Text()("Alert Message with default button")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a2)(
            View(style = styles.button)(
              Text()("Alert with only one button")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a3)(
            View(style = styles.button)(
              Text()("Alert with two buttons")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a4)(
            View(style = styles.button)(
              Text()("Alert with 3 buttons")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a5)(
            View(style = styles.button)(
              Text()("Alert with too many buttons")
            )
          )
        )
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {
    val alertsContainer = style(backgroundColor := "white",
      padding := 20)
    val wrapper = style(borderRadius := 5, marginBottom := 5)
    val button = style(backgroundColor := "#eeeeee", padding := 10)
  }

  override def description: String = "iOS alerts and action sheets"
}
