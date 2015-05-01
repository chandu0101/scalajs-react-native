package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js


object TouchableExample extends UIExample {

  val heartImage = ImageSource(uri = "https://pbs.twimg.com/media/BlXBfT3CQAA6cVZ.png:small")
  val component = ReactNativeComponentB[Unit]("TouchableExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock(title = "TouchableHighlight")(
        View(style = styles.row)(
          TouchableHighlight(style = styles.wrapper, onPress = () => println("stock THW image - highlight"))(
            Image(source = heartImage, style = styles.image)
          ),
          TouchableHighlight(style = styles.wrapper,
            activeOpacity = 1,
            animationVelocity = 1,
            underlayColor = "rgb(210, 230, 255)",
            onPress = () => println("custom THW text - hightlight"))(
              Text(style = styles.text)(
                "Tap Here For Custom Highlight!"
              )
            )
        )
      ),
      UIExplorerBlock(title = "Touchable feedback events")(
        TouchableFeedbackEvents()
      )
    )
  }).buildNative

  case class State(eventLog: js.Array[String] = js.Array())

  class Backend(t: BackendScope[_, State]) {

    def appendEvent(name: String) = {
      val eventLog = t.state.eventLog.slice(0, 5)
      t.modState(_.copy(eventLog = name +: eventLog))
    }
  }

  val TouchableFeedbackEvents = ReactNativeComponentB[Unit]("TouchableFeedbackEvents")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    View()(
      View(style = styles.wrapper)(
        TouchableOpacity(style = styles.wrapper,
          onPress = () => B.appendEvent("press"),
          onPressIn = () => B.appendEvent("pressIn"),
          onPressOut = () => B.appendEvent("pressOut"),
          onLongPress = () => B.appendEvent("longPress"))(
            Text(style = styles.button)("Press Me")
          )
      ),
      View(style = styles.eventLogBox)(
       S.eventLog.zipWithIndex.map {
         case (e,i) => Text(key = i.toString)(e)
       }
      )
    )
  }).buildU


  object styles extends NativeStyleSheet {

    val row = style(justifyContent.center,
      flexDirection.row)

    val icon = style(width := 24,
      height := 24)

    val image = style(width := 50,
      height := 50)

    val text = style(fontSize := 15)

    val button = style(color := "#007AFF")

    val wrapper = style(borderRadius := 8)

    val wrapperCustom = style(
      borderRadius := 8,
      padding := 6
    )
    val logBox = style(
      padding := 20,
      margin := 10,
      borderWidth := 1.0 / rn.ReactNative.PixelRatio.get(),
      borderColor := "#f0f0f0",
      backgroundColor := "#f9f9f9"
    )
    val eventLogBox = style(
      padding := 10,
      margin := 10,
      height := 120,
      borderWidth := 1.0 / rn.ReactNative.PixelRatio.get(),
      borderColor := "#f0f0f0",
      backgroundColor := "#f9f9f9"
    )

    val textBlock = style(
      fontWeight._500,
      color := "blue"
    )
  }

  override def title: String = "Touchable*"

  override def description: String = "TouchableHighlight,TouchableOpacity .."

}
