package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 *
 * key: PropTypes.string,
   date: PropTypes.Date.isRequired,
    onDateChange: PropTypes.func.isRequired,
    maximumDate: PropTypes.Date,
    minimumDate: PropTypes.Date,
    mode: PropTypes.string,
    minuteInterval: PropTypes.number,
    timeZoneOffsetInMinutes: PropTypes.number,
 */


case class DatePickerIOS(timeZoneOffsetInMinutes: UndefOr[Int] = undefined,
                         key: UndefOr[String] = undefined,
                         date: js.Date,
                         minuteInterval: UndefOr[Int] = undefined,
                         mode: UndefOr[String] = undefined,
                         minimumDate: UndefOr[js.Date] = undefined,
                         maximumDate: UndefOr[js.Date] = undefined,
                         onDateChange: js.Function) {

  def toJS = {
    val p = js.Dynamic.literal()
    timeZoneOffsetInMinutes.foreach(v => p.updateDynamic("timeZoneOffsetInMinutes")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    p.updateDynamic("date")(date)
    minuteInterval.foreach(v => p.updateDynamic("minuteInterval")(v))
    mode.foreach(v => p.updateDynamic("mode")(v))
    minimumDate.foreach(v => p.updateDynamic("minimumDate")(v))
    maximumDate.foreach(v => p.updateDynamic("maximumDate")(v))
    p.updateDynamic("onDateChange")(onDateChange)
    p
  }

  def apply(children: ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.DatePickerIOS)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     
