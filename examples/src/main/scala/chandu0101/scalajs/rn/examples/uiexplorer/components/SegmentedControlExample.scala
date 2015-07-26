package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.components.{SegmentedControlIOS, Text, View}
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.styles.NativeStyleSheet
import chandu0101.scalajs.rn.{NEvent, ReactNativeComponentB}
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSON


object SegmentedControlExample extends UIExample {

  val BasicSegmentedControlExample = ReactNativeComponentB[Unit]("BasicSegmentedControlExample")
    .render(P => {
    View()(
      SegmentedControlIOS(values = Seq("One", "Two"))
    )
  }).buildU

  val PreSelectedSegmentedControlExample = ReactNativeComponentB[Unit]("PreSelectedSegmentedControlExample")
    .render(P => {
    View()(
      SegmentedControlIOS(values = Seq("One", "Two"), selectedIndex = 0)
    )
  }).buildU

  val MomentarySegmentedControlExample = ReactNativeComponentB[Unit]("MomentarySegmentedControlExample")
    .render(P => {
    View()(
      SegmentedControlIOS(values = Seq("One", "Two"), momentary = true)
    )
  }).buildU

  val DisabledSegmentedControlExample = ReactNativeComponentB[Unit]("DisabledSegmentedControlExample")
    .render(P => {
    View()(
      SegmentedControlIOS(values = Seq("One", "Two"), enabled = false, selectedIndex = 0)
    )
  }).buildU

  val ColorSegmentedControlExample = ReactNativeComponentB[Unit]("ColorSegmentedControlExample")
    .render(P => {
    View()(
      SegmentedControlIOS(values = Seq("One", "Two"), selectedIndex = 0, tintColor = "#ff0000")
    )
  }).buildU

  case class State(values : Seq[String] = Seq("One", "Two","Three","Four"),  value: String = "One", index: Int = 0)

  class Backend(t: BackendScope[_, State]) {
    def onChange(e: js.Dynamic) = {
      t.modState(_.copy(index = e.nativeEvent.selectedSegmentIndex.toString.toInt))
    }

    def onValueChange(value: String) = t.modState(_.copy(value = value))
  }

  val EventSegmentedControlExample = ReactNativeComponentB[Unit]("EventSegmentedControlExample")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    View()(
      Text(style = styles.text)(s"Value : ${S.value}"),
      Text(style = styles.text)(s"Index : ${S.values.indexOf(S.value)}"),
      SegmentedControlIOS(values = S.values, selectedIndex = S.index,
        tintColor = "#cf00a2",
        onChange = B.onChange _,
        onValueChange = B.onValueChange _
      )
    )
  }).buildU


  val component = ReactNativeComponentB[Unit]("SegmentedControlExample")
    .render(P => {
    UIExplorerPage(
      View()(
        UIExplorerBlock("Segmented controls can have values")(
          BasicSegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can have a pre-selected value")(
          PreSelectedSegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can be momentary")(
          MomentarySegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can be disabled")(
          DisabledSegmentedControlExample()
        ),
        UIExplorerBlock("Custom colors can be provided")(
          ColorSegmentedControlExample()
        ),
        UIExplorerBlock("Change events can be detected")(
          EventSegmentedControlExample()
        )
      )
    )

  }).buildNative


  object styles extends NativeStyleSheet {

    val text = style(fontSize := 14,
      textAlign.center,
      fontWeight._500,
      margin := 10)


  }


  override def title: String = "SegmentedControlIOS"

  override def description: String = "Native segmented control"
}
