package chandu0101.scalajs.rn.components

import chandu0101.scalajs.rn.ReactNative
import japgolly.scalajs.react.{ReactComponentU_, ReactNode}

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 4/2/15.
 *
 *  key: PropTypes.string,
 *  style : PropTypes.Any,
    onPress: PropTypes.func,
    onPressIn: PropTypes.func,
    onPressOut: PropTypes.func,
    onLongPress: PropTypes.func,
    activeOpacity:PropTypes.number,
 */

case class TouchableOpacity(onPressIn : UndefOr[() => _] = undefined ,
                            onPress : UndefOr[() => _] = undefined ,
                            style : UndefOr[js.Any] = undefined ,
                            onPressOut : UndefOr[() => _] = undefined ,
                            key : UndefOr[String] = undefined,
                            onLongPress : UndefOr[() => _] = undefined ,
                            activeOpacity : UndefOr[Int] = undefined) {

  def toJS = {
    val p = js.Dynamic.literal()
    onPressIn.foreach(v => p.updateDynamic("onPressIn")(v))
    onPress.foreach(v => p.updateDynamic("onPress")(v))
    onPressOut.foreach(v => p.updateDynamic("onPressOut")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onLongPress.foreach(v => p.updateDynamic("onLongPress")(v))
    activeOpacity.foreach(v => p.updateDynamic("activeOpacity")(v))
    p
  }

  def apply(child : ReactNode) = {
    val f = ReactNative.createFactory(ReactNative.TouchableOpacity)
    f(toJS,child).asInstanceOf[ReactComponentU_]
  }
}
     