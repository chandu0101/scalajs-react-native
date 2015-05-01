package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/1/15.
 *  key: PropTypes.string,
   value: PropTypes.bool,
    disabled: PropTypes.bool,
    onValueChange: PropTypes.func,
    onTintColor: PropTypes.string,
    thumbTintColor: PropTypes.string,
    tintColor: PropTypes.string,
     style :PropTypes.Any
 */


object SwitchIOS {

  def apply(tintColor : UndefOr[String] = undefined,
            key : UndefOr[String] = undefined,
            thumbTintColor : UndefOr[String] = undefined,
            onValueChange : UndefOr[(Boolean) => _] = undefined ,
            onTintColor : UndefOr[String] = undefined,
            disabled : UndefOr[Boolean]=undefined,
            style : UndefOr[js.Any]=undefined,
            value : UndefOr[Boolean]=undefined) = {
    val p = js.Dynamic.literal()
    tintColor.foreach(v => p.updateDynamic("tintColor")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    thumbTintColor.foreach(v => p.updateDynamic("thumbTintColor")(v))
    onValueChange.foreach(v => p.updateDynamic("onValueChange")(v))
    onTintColor.foreach(v => p.updateDynamic("onTintColor")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    val f = ReactNative.createFactory(ReactNative.SwitchIOS)
    f(p).asInstanceOf[ReactComponentU_]
  }
}
     