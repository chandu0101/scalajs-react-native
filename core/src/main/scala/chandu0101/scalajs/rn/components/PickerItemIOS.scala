package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.ReactComponentU_

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String
    value:PropTypes.T
label:PropTypes.string
 */
object PickerItemIOS {

  def apply[T](key: UndefOr[String] = undefined,
            style: UndefOr[js.Any] = undefined,
            ref: UndefOr[String] = undefined,
            value : UndefOr[T] = undefined,
                label : UndefOr[String] = undefined) = {
    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    value.foreach(v => p.updateDynamic("value")(if(v.isInstanceOf[Int]) v.asInstanceOf[Int] else v.toString))
    label.foreach(v => p.updateDynamic("label")(v))

    val f = ReactNative.createFactory(ReactNative.PickerIOS.asInstanceOf[js.Dynamic].Item.asInstanceOf[js.Object])
    f(p).asInstanceOf[ReactComponentU_]
  }
}