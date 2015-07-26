package chandu0101.scalajs.rn.examples.uiexplorer.components

import chandu0101.scalajs.rn.components._
import chandu0101.scalajs.rn.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.rn.{NEvent, ReactNativeComponentB}
import japgolly.scalajs.react.BackendScope
import chandu0101.scalajs.rn.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Date
import scala.util.Try

object DatePickerIOSExample extends UIExample {

  val Heading = ReactNativeComponentB[String]("Heading")
    .render(P => {
    View(style = styles.headingContainer)(
      Text(style = styles.heading)(
        P
      )
    )
  }).build

  val WithLabel = ReactNativeComponentB[String]("WithLabel")
    .render((P, C) => {
    View(style = styles.headingContainer)(
      View(style = styles.labelView)(
        Text(style = styles.heading)(
          P
        ),
        C
      )

    )
  }).build

  val x = (-1) * (new Date()).getTimezoneOffset() / 60

  case class State(date: js.Date, timeZoneOffsetInHours: Double)

  class Backend(t: BackendScope[_, State]) {
    def onDateChange(date: js.Date) = {
      t.modState(_.copy(date = date))
    }

    def onTimezoneChange(event: NEvent) = {
      val offset = Try(event.nativeEvent.text.toString.toInt).toOption
      if (offset.isDefined) t.modState(_.copy(timeZoneOffsetInHours = offset.get))
    }
  }

  val DatePickerExample = ReactNativeComponentB[js.Date]("DatePickerExample")
    .initialStateP(p => State(p, (-1) * (new Date()).getTimezoneOffset() / 60.0))
    .backend(new Backend(_))
    .render((P, S, B) => {
    View()(
      WithLabel("Value :",
        Text()(s"${S.date.toLocaleDateString()} ${S.date.toLocaleTimeString()}")),
      WithLabel("Timezone :",
        TextInput(style = styles.textInput,
          value = S.timeZoneOffsetInHours.toString,
          onChange = B.onTimezoneChange _)()),
      Heading("Date + TimePicker"),
      DatePickerIOS(date = S.date,
        mode = DatePickerIOSMode.DATE_TIME, timeZoneOffsetInMinutes = (S.timeZoneOffsetInHours * 60).toInt,
        onDateChange = B.onDateChange _),
      Heading("Date Picker"),
      DatePickerIOS(date = S.date,
        mode = DatePickerIOSMode.DATE, timeZoneOffsetInMinutes = (S.timeZoneOffsetInHours * 60).toInt,
        onDateChange = B.onDateChange _),
      Heading("Time picker 10-minute interval"),
      DatePickerIOS(date = S.date,
        mode = DatePickerIOSMode.TIME,
        timeZoneOffsetInMinutes = (S.timeZoneOffsetInHours * 60).toInt,
        onDateChange = B.onDateChange _,
        minuteInterval = MinuteInterval._10)

    )
  }).build


  val component = ReactNativeComponentB[Unit]("DatePickerIOSExample")
    .render(P => {
     UIExplorerPage(
      UIExplorerBlock("DatePickerIOS")(
        DatePickerExample(new Date())
      )
     )
  }).buildNative

  object styles extends NativeStyleSheet {

    val textInput = style(height := 26,
      width := 50,
      borderWidth := 0.5,
      borderColor := "#0f0f0f",
      padding := 4,
      fontSize := 13)

    val labelContainer = style(flexDirection.row,
      alignItems.center,
      marginVertical := 2)

    val labelView = style(marginRight := 10,
      paddingVertical := 2)

    val label = style(fontWeight._500)

    val headingContainer = style(padding := 4,
      backgroundColor := "#f6f7f8")

    val heading = style(fontWeight._500, fontSize := 14)

  }

  override def title: String = "DatePickerIOS"

  override def description: String = "Select dates and times using the native UIDatePicker."
}
