package chandu0101.scalajs.rn.components

import chandu0101.scalajs
import chandu0101.scalajs.rn
import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

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
 */


case class SwitchIOS(tintColor : UndefOr[String] = undefined,
                     key : UndefOr[String] = undefined,
                     thumbTintColor : UndefOr[String] = undefined,
                     onValueChange : UndefOr[js.Function] = undefined ,
                     onTintColor : UndefOr[String] = undefined,
                     disabled : UndefOr[Boolean]=undefined,
                     value : UndefOr[Boolean]=undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    tintColor.foreach(v => p.updateDynamic("tintColor")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    thumbTintColor.foreach(v => p.updateDynamic("thumbTintColor")(v))
    onValueChange.foreach(v => p.updateDynamic("onValueChange")(v))
    onTintColor.foreach(v => p.updateDynamic("onTintColor")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = ReactNative.createFactory(ReactNative.SwitchIOS)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
     