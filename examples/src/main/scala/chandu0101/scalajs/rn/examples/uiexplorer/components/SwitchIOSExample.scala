package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.ReactNativeComponentB
import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import japgolly.scalajs.react.BackendScope
import main.scala.chandu0101.scalajs.rn.styles.NativeStyleSheet

object SwitchIOSExample extends UIExample {

  case class BasicState(trueSwitchIsOn: Boolean = true, falseSwitchIsOn: Boolean = false)

  class Backend(t: BackendScope[_, BasicState]) {

    def handleFalseSwitch(value: Boolean) = {
      t.modState(_.copy(falseSwitchIsOn = value))
    }

    def handleTrueSwitch(value: Boolean) = {
      t.modState(_.copy(trueSwitchIsOn = value))
    }
  }

  val BasicSwitchExample = ReactNativeComponentB[Unit]("BasicSwitchExample")
    .initialState(BasicState())
    .backend(new Backend(_))
    .render((P, S, B) => {
    View()(
      SwitchIOS(onValueChange = B.handleFalseSwitch _,
        style = styles.basicFalseSwitch,
        value = S.falseSwitchIsOn),
      SwitchIOS(onValueChange = B.handleTrueSwitch _,
        value = S.trueSwitchIsOn)
    )
  }).buildU


  val DisabledSwitchExample = ReactNativeComponentB[Unit]("DisabledSwitchExample")
    .render(P => {
    View()(
      SwitchIOS(disabled = true, style = styles.basicFalseSwitch, value = true),
      SwitchIOS(disabled = true,
        value = false)
    )
  }).buildU

  val ColorSwitchExample = ReactNativeComponentB[Unit]("ColorSwitchExample")
    .initialState(BasicState())
    .backend(new Backend(_))
    .render((P, S, B) => {
    View()(
      SwitchIOS(onValueChange = B.handleFalseSwitch _,
        style = styles.basicFalseSwitch,
        onTintColor = "#00ff00",
        tintColor = "#ff0000",
        value = S.falseSwitchIsOn),
      SwitchIOS(onValueChange = B.handleTrueSwitch _,
        onTintColor = "#00ff00",
        tintColor = "#ff0000",
        value = S.trueSwitchIsOn)
    )
  }).buildU

  case class State(eventSwitchIsOn: Boolean = false, eventSwitchRegressionIsOn: Boolean = true)

  class Backend2(t: BackendScope[_, State]) {

    def handleEventSwitch(value: Boolean) = {
      t.modState(_.copy(eventSwitchIsOn = value))
    }

    def handleEventSwitchRegression(value: Boolean) = {
      t.modState(_.copy(eventSwitchRegressionIsOn = value))
    }

  }

  val EventSwitchExample = ReactNativeComponentB[Unit]("EventSwitchExample")
    .initialState(State())
    .backend(new Backend2(_))
    .render((P, S, B) => {
    View(style = styles.eventsContainer)(
      View()(
        SwitchIOS(onValueChange = B.handleEventSwitch _,
          style = styles.basicFalseSwitch,
          value = S.eventSwitchIsOn),
        SwitchIOS(onValueChange = B.handleEventSwitch _,
          style = styles.basicFalseSwitch,
          value = S.eventSwitchIsOn),
        Text()(if (S.eventSwitchIsOn) "On" else "Off")
      ),
      View()(
        SwitchIOS(onValueChange = B.handleEventSwitchRegression _,
          style = styles.basicFalseSwitch,
          value = S.eventSwitchRegressionIsOn),
        SwitchIOS(onValueChange = B.handleEventSwitchRegression _,
          style = styles.basicFalseSwitch,
          value = S.eventSwitchRegressionIsOn),
        Text()(if (S.eventSwitchRegressionIsOn) "On" else "Off")
      )
    )
  }).buildU


  val component = ReactNativeComponentB[Unit]("WebViewExample")
    .render(P => {
    UIExplorerPage(
      UIExplorerBlock("Basic Switch")(
        BasicSwitchExample()
      ),
      UIExplorerBlock("Disabled Switches")(
        DisabledSwitchExample()
      ),
      UIExplorerBlock("Colored Switches")(
        ColorSwitchExample()
      ),
      UIExplorerBlock("Change events can be detected")(
        EventSwitchExample()
      )
    )
  }).buildNative

  object styles extends NativeStyleSheet {

    val basicFalseSwitch = style(marginBottom := 10)

    val eventsContainer = style(flexDirection.row,
      justifyContent.spaceAround)
  }

  override def title: String = "SwitchIOSExample"

  override def description: String = "Native boolean input"
}
