package chandu0101.scalajs.rn.examples.uiexplorer.apis

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

object PushNotificationIOSExample extends UIExample {

  val PushNotificationIOS = rn.ReactNative.PushNotificationIOS

   val Button = ReactNativeComponentB[ButtonProps]("Button")
         .render( P => {
            TouchableHighlight(underlayColor = "white",
            style = styles.button,
            onPress = P.onPress)(
               Text(style = styles.buttonLabel)(P.label)
              )
         }).build

  case class ButtonProps(label : String,onPress : () => _)

  val component = ReactNativeComponentB[Unit]("PushNotificationIOSExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("Badge Number")(
       View()(
        Button(ButtonProps("Set app's icon badge to 42",() => PushNotificationIOS.setApplicationIconBadgeNumber(42) )),
        Button(ButtonProps("Clear app's icon badge",() => PushNotificationIOS.setApplicationIconBadgeNumber(0) ))
       )
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {

    val button = style(padding := 10,
    alignItems.center,
    justifyContent.center)

    val buttonLabel = style(color := "blue")
  }

  override def title: String = "PushNotificationIOS"

  override def description: String = "Apple PushNotification and badge value"
}
